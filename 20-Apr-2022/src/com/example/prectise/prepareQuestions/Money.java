package com.example.prectise.prepareQuestions;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Money implements Comparable<Money>{
    private static final Currency INR = Currency.getInstance(new Locale("en", "in"));
    private static final NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
    private final BigDecimal amount;
    private final Currency currency;
    public static Money rupees(BigDecimal amount) {
        return new Money(amount, INR);
    }
    Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public Currency getCurrency() {
        return currency;
    }
    public boolean isSameCurrencyAs(Money aThat){
        boolean result = false;
        if ( aThat != null ) {
            result = this.currency.equals(aThat.currency);
        }
        return result;
    }
    private void checkCurrenciesMatch(Money aThat){
        if (! isSameCurrencyAs(aThat)) {
            throw new RuntimeException(aThat.getCurrency() + " doesn't match the expected currency : " + currency);
        }
    }
    public Money minus(Money aThat){
        checkCurrenciesMatch(aThat);
        return new Money(amount.subtract(aThat.amount), currency);
    }
    @Override
    public String toString() {
        return format.format(amount);
    }
    public String toString(Locale locale) {
        return getCurrency().getSymbol(locale) + " " + getAmount();
    }
    @Override
    public int compareTo(Money o) {
        return o.getAmount().compareTo(amount);
    }
    public static void main(String[] args) {
        Money rupees = Money.rupees(new BigDecimal("100"));
        System.out.println("rupees = " + rupees);
    }
}