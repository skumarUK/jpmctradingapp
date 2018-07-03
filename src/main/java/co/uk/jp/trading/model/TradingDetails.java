/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.model;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Trading details sent for settlement.
 */
public class TradingDetails {

    private final Currency currency;
    private final BigDecimal agreedFx;
    private final int units;
    private final BigDecimal pricePerUnit;

    public TradingDetails(Currency currency, BigDecimal agreedFx, int units, BigDecimal pricePerUnit) {
        this.currency = currency;
        this.agreedFx = agreedFx;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getTradeAmount() {
        return this.getPricePerUnit()
            .multiply(BigDecimal.valueOf(this.getUnits()))
            .multiply(this.getAgreedFx());
    }

    public BigDecimal getAgreedFx() {
        return agreedFx;
    }

    public int getUnits() {
        return units;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    @Override public String toString() {

        return "TradingDetails{" +
            "currency=" + currency +
            ", agreedFx=" + agreedFx +
            ", units=" + units +
            ", pricePerUnit=" + pricePerUnit +
            '}';
    }
}
