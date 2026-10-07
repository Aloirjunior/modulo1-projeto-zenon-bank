package br.com.zenon.fraud;

import br.com.zenon.TransactionIngestor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Modifique o TransactionIngestor para carregar 100.000 transações no List<Transaction>.
*
* Crie uma classe TransactionListRepository que define um método que
* busca uma transação por nome do cliente de origem e retorna
* Optional<Transaction>, indicando que o valor pode não existir. Teste a
* Teste a busca na Main com o arquivo PaySim completo / sem
* o arquivo PaySim completo / sem 1006815)  e não existentes (ex. C12345). Exemplo de retorno:
 * */
public class TransactionListRepository implements TransactionRepository{

    List<Transaction> transactionObject = new ArrayList<>();

    public TransactionListRepository(List<Transaction> transactionObject) {
        Objects.requireNonNull(transactionObject);
        this.transactionObject = transactionObject;
    }

    @Override
    public Optional<Transaction> findByName(String nome){
        Optional<Transaction> optionalTransaction = Optional.of(this.transactionObject
                .parallelStream()
                .filter(t -> t.transactionOrig().name().equals(nome))
                .toList().getFirst());
        return optionalTransaction;
    }

}
