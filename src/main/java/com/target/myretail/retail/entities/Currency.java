package com.target.myretail.retail.entities;

public enum Currency {
    USD("usd"),
    INR("inr"),
    EURO("euro"),
    YEN("yen");
    private final String displayName;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
