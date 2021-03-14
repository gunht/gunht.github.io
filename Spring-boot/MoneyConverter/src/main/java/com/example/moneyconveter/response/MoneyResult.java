package com.example.moneyconveter.response;

public class MoneyResult {
    private String moneyResult;
    private String amount;
    private String fromCode;
    private String toCode;

    public MoneyResult(String moneyResult, String amount, String fromCode, String toCode) {
        this.moneyResult = moneyResult;
        this.amount = amount;
        this.fromCode = fromCode;
        this.toCode = toCode;
    }

    public String getMoneyResult() {
        return moneyResult;
    }

    public void setMoneyResult(String moneyResult) {
        this.moneyResult = moneyResult;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }
}
