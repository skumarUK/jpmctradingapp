/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import com.google.gson.annotations.SerializedName;

import co.uk.jp.trading.constants.TradingAction;

/**
 * Describes an instruction sent by various clients in order to buy or sell
 */
public class Instruction {

    private final String entity;

    @SerializedName("instructionType")
    private final TradingAction action;

    private final LocalDate instructionDate;

    private final TradingDetails details;

    private LocalDate settlementDate;

    public Instruction(
        String entity,
        TradingAction action,
        LocalDate instructionDate,
        LocalDate settlementDate,
        TradingDetails details)
    {
        this.entity = entity;
        this.action = action;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.details = details;
    }

    public String getEntity() {
        return entity;
    }

    public TradingAction getAction() {
        return action;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }
    public LocalDate getSettlementDate() {
        return settlementDate;
    }
    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }
    public TradingDetails getDetails() {
        return details;
    }

    public BigDecimal getTradeAmount() {return getDetails().getTradeAmount()
        .setScale(2, BigDecimal.ROUND_HALF_EVEN);}

    public Currency getCurrency() {return getDetails().getCurrency();}

    public int getUnits() {
        return getDetails().getUnits();
    }

    public BigDecimal getPricePerUnit() {
        return getDetails().getPricePerUnit();
    }

    public BigDecimal getAgreedFx() {
        return getDetails().getAgreedFx();
    }

    @Override public String toString() {

        return "Instruction{" +
            "entity='" + entity + '\'' +
            ", action=" + action +
            ", instructionDate=" + instructionDate +
            ", details=" + details.toString() +
            ", settlementDate=" + settlementDate +
            '}';
    }
}
