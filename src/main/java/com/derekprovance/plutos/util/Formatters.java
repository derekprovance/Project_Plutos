package com.derekprovance.plutos.util;

import java.text.DecimalFormat;

public class Formatters {
    public static String convertToStringCurrency(Long value) {
        return String.format("$%s", Double.valueOf(value) / 10000);
    }

    public static String convertToRoundedStringCurrency(Long value) {
        DecimalFormat twoDigitDec = new DecimalFormat("#0.00");
        Double convertedValue = Double.valueOf(value) / 10000;

        return String.format("$%s", twoDigitDec.format(convertedValue));
    }
}
