/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.app;

import static co.uk.jp.trading.strategy.reportingstrategy.ReportBuilder.generateDailyReporting;

import java.util.Set;

import co.uk.jp.trading.Utils.LoadDailyTradingInstructions;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.settlement.ISettlementService;
import co.uk.jp.trading.service.settlement.impl.SettlementServiceImpl;
/**
 * TradingService main class.
 *
 */
public class TradingServiceMain {

    public static void main (String args[]){

        Set<Instruction> instructions =
            LoadDailyTradingInstructions.loadDailyTradingInstructions("dailytradingInstructions.json");
        ISettlementService settlementService = new SettlementServiceImpl();
             settlementService.checkAndUpdateSettlementDates(instructions);
        generateDailyReporting(instructions);
    }


}
