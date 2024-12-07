package com.avila.quotations.model;

public enum CurrencyPair {
    USD_BRL;

    @Override
    public String toString() {
        return this.name()
                .toUpperCase()
                .replace("_", "-");
    }
}
