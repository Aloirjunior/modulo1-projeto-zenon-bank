package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Transacoes transacoes = new Transacoes();

        Integer id = transacoes.getId() + 1;
        transacoes.setTransacao(
           id,
           new Transaction(1,
                   "PAYMENT",
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
                   "CASH_OUT",
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