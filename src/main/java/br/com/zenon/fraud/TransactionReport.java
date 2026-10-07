package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class TransactionReport {

    public record Statistics(long totalTrasaction, long totalFraud, BigDecimal totalAmount){

        private Statistics add(ReportTransaction rt){
            return new Statistics(
                    totalTrasaction + 1,
                    totalFraud + (rt.isFraud() ? 1 : 0),
                    totalAmount.add(rt.amount())
            );
        }
    }

    public Statistics GetTrasactionReport(String nomeArquivo) {
        Path file = Path.of("src/main/data/" + nomeArquivo);
        try(Stream<String> lines = Files.lines(file)) {
            return lines.skip(1)
                 .map(TransactionReport::parseTransactionReport)
                 .filter(Optional::isPresent)
                 .map(Optional::get)
                 .reduce(
                    new Statistics(0, 0, BigDecimal.ZERO),
                    Statistics::add,
                         (Statistics s1, Statistics s2)-> s1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<ReportTransaction> parseTransactionReport(String line){
        String[] elements = line.split(",");
        try{
            return Optional.of(new ReportTransaction(
                 BigDecimal.valueOf(Double.parseDouble(elements[2])),
                 Integer.parseInt(elements[9]) == 1
               )
            );
        } catch (RuntimeException e) {
            System.err.println("ERRO: " + line + " |" + e);
            return Optional.empty();
        }
    }
}
