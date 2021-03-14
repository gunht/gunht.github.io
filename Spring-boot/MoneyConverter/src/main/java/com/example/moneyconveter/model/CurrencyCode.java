package com.example.moneyconveter.model;

import java.util.Comparator;

public class CurrencyCode implements Comparable<CurrencyCode> {
    private String Country;
    private String CountryCode;
    private String Currency;
    private String Code;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public int compareTo(CurrencyCode o) {
        return this.getCountry().compareTo(o.getCountry());
    }
}
