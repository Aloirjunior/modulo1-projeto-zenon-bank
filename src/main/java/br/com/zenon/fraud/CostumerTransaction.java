package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.Objects;

public record CostumerTransaction(String name, BigDecimal oldBalance, BigDecimal newBalance) {

    public CostumerTransaction {
        Objects.requireNonNull(name);
        Objects.requireNonNull(oldBalance);
        Objects.requireNonNull(newBalance);
        if(newBalance.signum() < 0){
            throw new IllegalArgumentException(" O valor de newBalance deve ser positivo: " + newBalance);
        }else if(oldBalance.signum() < 0){
            throw new IllegalArgumentException(" O valor de oldBalance deve ser positivo: " + oldBalance);
        }else if(name.isEmpty()){
            throw new IllegalArgumentException(" name não pode ser nulo ou vazio: " + name);
        }
    }
}
