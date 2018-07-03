/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.constants;

import java.util.Arrays;
import java.util.function.Predicate;
/**
 * Trading Action is Enum type constants supported by this API.
 */
public enum TradingAction {
    BUY("B"),
    SELL("S");

    private String value;

    TradingAction(String value) {
        this.value = value;
    }
    /**
     * Returns TradingAction Enum based on the value.
     * i.e. "B" = TradingAction.BUY
     * "S" = TradingAction.SELL
     * @param value passed enum value to get Enum Constant.
     * @return TradingAction
     * @throws java.util.NoSuchElementException, when there is no matching Enum value exists.
     */
    public static TradingAction getByValue(String value){
        final Predicate<TradingAction> tradingActionPredicate =
            tradingAction -> tradingAction.getValue().equalsIgnoreCase(value);
        return Arrays.stream(TradingAction.values()).filter(tradingActionPredicate).findFirst().get();
    }
    public String getValue() {
        return this.value;
    }
}
