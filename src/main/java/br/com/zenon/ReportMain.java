package br.com.zenon;

import br.com.zenon.fraud.*;

import br.com.zenon.fraud.TransactionReport.Statistics ;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ReportMain {
    public static void main(String[] args) {
        TransactionReport transactionReport = new TransactionReport();
        Statistics statistics = transactionReport.GetTrasactionReport("PS_log.csv");
        while (0<1){
            Locale locale = Locale.of("pt");

            System.out.println("Digite 1 para Portugues: ");
            System.out.println("Digite 2 para Inglês: ");
            int lang = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println();
            locale = switch (lang) {
                case 1 -> Locale.of("pt");
                case 2 -> Locale.of("en");
                default -> locale;
            };
            
            var numberFormat = NumberFormat.getIntegerInstance(locale);
            var currencyInstance = DecimalFormat.getCurrencyInstance(Locale.of("pt"));
            currencyInstance.setCurrency(Currency.getInstance("USD"));

            ResourceBundle resourceBundle = ResourceBundle.getBundle("report", locale);
            System.out.println(resourceBundle.getString("total_linhas") + " " + numberFormat.format(statistics.totalTrasaction()) + "\n" +
                    resourceBundle.getString("total_fraudes") + " " + numberFormat.format(statistics.totalFraud()) + "\n" +
                    resourceBundle.getString("total_transacoes") + " " + currencyInstance.format(statistics.totalAmount()) + "\n");
        }
    }
}