package br.com.zenon;

import br.com.zenon.fraud.*;

import br.com.zenon.fraud.TransactionReport.Statistics ;

public class ReportMain {
    public static void main(String[] args){
        TransactionReport transactionReport = new TransactionReport();
        Statistics statistics = transactionReport.GetTrasactionReport("PS_log.csv");
        System.out.println("Total de linhas: " + statistics.totalTrasaction()+"\n" +
                "Total de fraudes: "+statistics.totalFraud()+
                "\nValor total transacionado: " + statistics.totalAmount());
    }

}