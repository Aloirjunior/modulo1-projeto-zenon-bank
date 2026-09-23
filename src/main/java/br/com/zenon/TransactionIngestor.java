package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TransactionIngestor {


    public TransactionIngestor(){}

    public List<Transaction> recuperarListaArquivo(String nomeArquivo) throws IOException {
        List<Transaction> itemTransacoesList = new ArrayList<>();
        String nomeCompleto = "src/main/data/"+nomeArquivo;
        Stream<String> stream = Files.lines(Path.of(nomeCompleto));
        stream.skip(1).limit(1000).forEach(e->{
            String[] elements = e.split(",");
            itemTransacoesList.add(new Transaction(
               Integer.parseInt(elements[0]),
               Type.valueOf(String.valueOf(elements[1])),
               BigDecimal.valueOf(Double.parseDouble(elements[2])),
               String.valueOf(elements[3]),
               BigDecimal.valueOf(Double.parseDouble(elements[4])),
               BigDecimal.valueOf(Double.parseDouble(elements[5])),
               String.valueOf(elements[6]),
               BigDecimal.valueOf(Double.parseDouble(elements[7])),
               BigDecimal.valueOf(Double.parseDouble(elements[8])),
               Integer.parseInt(elements[9])
            ));
        });
        return itemTransacoesList;
    }
}
