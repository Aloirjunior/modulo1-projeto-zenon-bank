package br.com.zenon.fraud;

import br.com.zenon.TransactionIngestor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* Modifique o TransactionIngestor para carregar 100.000 transações no List<Transaction>.
*
* Crie uma classe TransactionListRepository que define um método que
* busca uma transação por nome do cliente de origem e retorna
* Optional<Transaction>, indicando que o valor pode não existir. Teste a
* Teste a busca na Main com o arquivo PaySim completo / sem
* o arquivo PaySim completo / sem 1006815)  e não existentes (ex. C12345). Exemplo de retorno:
 * */
public class TransactionMapRepository implements TransactionRepository{


    Map<String, Transaction> stringTransactionMap = new HashMap<>();

    public TransactionMapRepository(List<Transaction> transactions) {
        Objects.requireNonNull(transactions);
        this.stringTransactionMap = transactions
                .parallelStream()
                .collect(Collectors.toMap(
                        transaction -> transaction.transactionOrig().name(),
                        Function.identity()));
    }

    @Override
    public Optional<Transaction> findByName(String nome) {
        return Optional.ofNullable(this.stringTransactionMap.get(nome));
    }
}
