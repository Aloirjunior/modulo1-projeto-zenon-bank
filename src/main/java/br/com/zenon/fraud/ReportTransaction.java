package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.Objects;

public record ReportTransaction(BigDecimal amount, boolean isFraud) {

    public ReportTransaction {
        Objects.requireNonNull(amount);
    }

}
