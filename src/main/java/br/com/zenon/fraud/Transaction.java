package br.com.zenon.fraud;

import br.com.zenon.Type;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public record Transaction(Integer step, Type type, BigDecimal amount, CostumerTransaction transactionOrig,
                          CostumerTransaction transactionDest, Integer isFraud) {

    public Transaction{
        Objects.requireNonNull(type);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(transactionOrig);
        Objects.requireNonNull(transactionDest);
        if(step < 1) {
            throw new IllegalArgumentException(" O valor de step deve ser maior que 0: " + step);
        }else if(amount.signum() < 0){
            throw new IllegalArgumentException(" O valor de amount deve ser positivo ou zero: " + amount);
        }
    }

}
