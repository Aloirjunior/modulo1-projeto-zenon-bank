package br.com.zenon;

import br.com.zenon.fraud.CostumerTransaction;
import br.com.zenon.fraud.Transaction;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionIngestor {


    public TransactionIngestor(){}
    public List<Transaction> recuperarListaArquivo(String nomeArquivo){
        AtomicInteger countError = new AtomicInteger(0);
        try {
            List<Transaction> transactions = Files.readAllLines(Path.of("src/main/data/" + nomeArquivo))
                    .stream()
                    .skip(1)
                    .limit(1000)
                    .map(linha-> parseTransaction(linha, countError))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
            System.err.println(countError.get());
            return  transactions;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<Transaction> parseTransaction(String line, AtomicInteger erro){
        String[] elements = line.split(",");
        try{
            return Optional.of(new Transaction(
                    Integer.parseInt(elements[0]),
                    Type.valueOf(String.valueOf(elements[1])),
                    BigDecimal.valueOf(Double.parseDouble(elements[2])),
                    new CostumerTransaction(String.valueOf(elements[3]),
                            BigDecimal.valueOf(Double.parseDouble(elements[4])),
                            BigDecimal.valueOf(Double.parseDouble(elements[5]))),
                    new CostumerTransaction( String.valueOf(elements[6]),
                            BigDecimal.valueOf(Double.parseDouble(elements[7])),
                            BigDecimal.valueOf(Double.parseDouble(elements[8]))),
                    Integer.parseInt(elements[9]))
            );
        } catch (RuntimeException e) {
            erro.incrementAndGet();
            System.err.println("ERRO: " + line + " |" + e);
            return Optional.empty();
        }
    }
}
