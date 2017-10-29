package com.derekprovance.util;

public class Formatters {
    public static String convertToStringCurrency(Long value) {
        return String.format("$%s", Double.valueOf(value) / 10000);
    }
}
