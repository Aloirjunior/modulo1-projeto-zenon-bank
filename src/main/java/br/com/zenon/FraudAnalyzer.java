package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class FraudAnalyzer {

    public FraudAnalyzer() {
    }

    public static void findFrauds(List<Transaction> transactions){
        try {
            System.out.println("1. Total de Fraudes: " + transactions.parallelStream().count());
            System.out.println("2. Top 3 Fraudes de Maior Valor: ");
            transactions.parallelStream().sorted(Comparator.comparing(Transaction::amount).reversed())
                    .limit(3)
                    .map(Transaction::amount)
                    .toList().forEach(val-> System.out.printf("%.2f%n", val));
            System.out.println("3. Clientes Suspeitos: ");
            transactions.parallelStream().collect(Collectors.groupingByConcurrent(
                       t -> t.transactionOrig().name(),
                       Collectors.reducing(
                               BigDecimal.ZERO,
                               Transaction::amount,
                               BigDecimal::add
                       )
                    )).entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                    .limit(5)
                    .toList().forEach(t -> System.out.println(t.getKey()));
            System.out.println("4. Prejuízo Total: " + transactions.parallelStream()
                    .map(Transaction::amount)
                    .reduce(BigDecimal.ZERO,BigDecimal::add));
            System.out.println("5. Fraudes por Tipo: ");
            transactions.parallelStream().collect(Collectors.groupingByConcurrent(
                            Transaction::type,
                            Collectors.counting()
                    )).forEach((type, aLong) -> {
                        System.out.println(type.toString()+": "+ aLong);
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
