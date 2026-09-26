package br.com.zenon;

import br.com.zenon.fraud.CostumerTransaction;
import br.com.zenon.fraud.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Transacoes transacoes = new Transacoes();
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        List<Transaction> listTransaction;
        int i = 0;
        while (i < 1) {
            System.out.println("\nCaso 1: Para dados mok: ");
            System.out.println("Caso 2: Para carregar dados da tabela: ");
            System.out.println("Caso 3: Para buscar fraudes: ");
            System.out.print("Digite um caso: ");
            int caso = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (caso) {
                case 1:
                    mokDados(transacoes);
                    break;
                case 2:
                    System.out.print("Digite nome do arquivo: ");
                    listTransaction = transactionIngestor.recuperarListaArquivo(new Scanner(System.in).nextLine(), 1000);
                    listTransaction.stream().limit(15).forEach(System.out::println);
                    System.out.println(listTransaction.size());
                    break;
                case 3:
                    System.out.print("Digite nome do arquivo: ");
                    FraudAnalyzer.findFrauds(transactionIngestor.recuperarListaArquivo(new Scanner(System.in).nextLine(), 50000));
                    break;
                default:
                    break;
            }
        }
    }

    public static void mokDados(Transacoes transacoes){
        Integer id = transacoes.getId() + 1;
        transacoes.setTransacao(
           id,
           new Transaction(1,
                   Type.PAYMENT,
                   new BigDecimal("9839.64"),
                   new CostumerTransaction(
                           "C1231006815",
                            new BigDecimal("170136.0"),
                            new BigDecimal("160296.36")),
                   new CostumerTransaction("M1979787155",
                   new BigDecimal("0.0"),
                   new BigDecimal("0.0")),
                   false)
        );
        System.out.println("Transação "+id+":");
        System.out.println(transacoes.getTrasacao(id));

        id = transacoes.getId() + 1;
        transacoes.setTransacao(
           id,
           new Transaction(743,
                   Type.CASH_OUT,
                   new BigDecimal("850002.52"),
                   new CostumerTransaction(
                           "C1280323807",
                            new BigDecimal("850002.52"),
                            new BigDecimal("0.0")),
                   new CostumerTransaction(
                           "C873221189",
                            new BigDecimal("6510099.11"),
                            new BigDecimal("7360101.63")),
                   true)
        );
        System.out.println("Transação "+id+":");
        System.out.println(transacoes.getTrasacao(id));
    }
}