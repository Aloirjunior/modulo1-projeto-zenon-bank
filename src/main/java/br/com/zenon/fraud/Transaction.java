package br.com.zenon.fraud;

import br.com.zenon.Type;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {

    private Integer step;
    private Type type;
    private BigDecimal amount;
    private String nameOrig;
    private BigDecimal oldbalanceOrg;
    private BigDecimal newbalanceOrig;
    private String nameDest;
    private BigDecimal oldbalanceDest;
    private BigDecimal newbalanceDest;
    private Integer isFraud;

    public Transaction(Integer step, Type type, BigDecimal amount, String nameOrig, BigDecimal oldbalanceOrg, BigDecimal newbalanceOrig, String nameDest, BigDecimal oldbalanceDest, BigDecimal newbalanceDest, Integer isFraud) {
        this.step = step;
        this.type = type;
        this.amount = amount;
        this.nameOrig = nameOrig;
        this.oldbalanceOrg = oldbalanceOrg;
        this.newbalanceOrig = newbalanceOrig;
        this.nameDest = nameDest;
        this.oldbalanceDest = oldbalanceDest;
        this.newbalanceDest = newbalanceDest;
        this.isFraud = isFraud;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public BigDecimal getOldbalanceOrg() {
        return oldbalanceOrg;
    }

    public void setOldbalanceOrg(BigDecimal oldbalanceOrg) {
        this.oldbalanceOrg = oldbalanceOrg;
    }

    public BigDecimal getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(BigDecimal newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = nameDest;
    }

    public BigDecimal getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setOldbalanceDest(BigDecimal oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public BigDecimal getNewbalanceDest() {
        return newbalanceDest;
    }

    public void setNewbalanceDest(BigDecimal newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    public Integer getFraud() {
        return isFraud;
    }

    public void setFraud(Integer fraud) {
        isFraud = fraud;
    }

    @Override
    public String toString() {
        return  "  step:" + step + "\n"+
                "  type:" + type + "\n"+
                "  amount:" + amount + "\n"+
                "  nameOrig:" + nameOrig + "\n"+
                "  oldbalanceOrg:" + oldbalanceOrg + "\n"+
                "  newbalanceOrig:" + newbalanceOrig + "\n"+
                "  nameDest:" + nameDest + "\n"+
                "  oldbalanceDest:" + oldbalanceDest + "\n"+
                "  newbalanceDest:" + newbalanceDest + "\n"+
                "  isFraud:" + isFraud+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(step, that.step) && Objects.equals(type, that.type) && Objects.equals(amount, that.amount) && Objects.equals(nameOrig, that.nameOrig) && Objects.equals(oldbalanceOrg, that.oldbalanceOrg) && Objects.equals(newbalanceOrig, that.newbalanceOrig) && Objects.equals(nameDest, that.nameDest) && Objects.equals(oldbalanceDest, that.oldbalanceDest) && Objects.equals(newbalanceDest, that.newbalanceDest) && Objects.equals(isFraud, that.isFraud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, type, amount, nameOrig, oldbalanceOrg, newbalanceOrig, nameDest, oldbalanceDest, newbalanceDest, isFraud);
    }
}
