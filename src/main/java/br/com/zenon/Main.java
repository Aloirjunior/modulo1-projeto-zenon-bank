package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Transacoes transacoes = new Transacoes();
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        int i = 0;
        while (i < 1) {
            System.out.println("Caso 1: Para dados mok: ");
            System.out.println("Caso 2: Para carregar dados da tabela: ");
            System.out.print("Digite um caso: ");
            int caso = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (caso) {
                case 1:
                    mokDados(transacoes);
                    break;
                case 2:
                    System.out.print("Digite nome do arquivo: ");
                    String nomeArquivo = new Scanner(System.in).nextLine();
                    List<Transaction> listTransaction = transactionIngestor.recuperarListaArquivo(nomeArquivo);
                    for(int t = 0; t < 9; t++){
                        System.out.println(listTransaction.get(t).toString());
                    }
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
                        "C1231006815",
                        new BigDecimal("170136.0"),
                        new BigDecimal("160296.36"),
                        "M1979787155",
                        new BigDecimal("0.0"),
                        new BigDecimal("0.0"),
                        0)
        );
        System.out.println("Transação "+id+":");
        System.out.println(transacoes.getTrasacao(id));

        id = transacoes.getId() + 1;
        transacoes.setTransacao(
                id,
                new Transaction(743,
                        Type.CASH_OUT,
                        new BigDecimal("850002.52"),
                        "C1280323807",
                        new BigDecimal("850002.52"),
                        new BigDecimal("0.0"),
                        "C873221189",
                        new BigDecimal("6510099.11"),
                        new BigDecimal("7360101.63"),
                        1)
        );
        System.out.println("Transação "+id+":");
        System.out.println(transacoes.getTrasacao(id));
    }
}