package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.io.IOException;
import java.util.HashMap;

public class Transacoes {
    HashMap<Integer ,Transaction> itemTransacoesList = new HashMap<>();

    public Transacoes() throws IOException {

    }

    public void setTransacao(Integer id, Transaction transaction){
        itemTransacoesList.put(id , transaction);
    }

    public Integer getId(){
        return itemTransacoesList.size();
    }

    public String getTrasacao(int id){
       return itemTransacoesList.get(id).toString();
    }
}
