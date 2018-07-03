/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy;

import static co.uk.jp.trading.constants.ReportingTypes.AMOUNT_SETTLEMENT_DAILY_REPORTING;
import static co.uk.jp.trading.constants.ReportingTypes.RANKING_DAILY_REPORTING;
import static co.uk.jp.trading.constants.TradingAction.BUY;
import static co.uk.jp.trading.constants.TradingAction.SELL;
import static co.uk.jp.trading.strategy.reportingstrategy.ReportingStrategyFactory.getReportingInstance;

import java.util.Set;

import co.uk.jp.trading.model.Instruction;

public class ReportBuilder {

    public static StringBuilder generateIncomingAmountSettlementDailyReport(Set<Instruction> instructions){
       return getReportingInstance(AMOUNT_SETTLEMENT_DAILY_REPORTING,SELL).generateReport(instructions);
    }

    public static StringBuilder generateOutgoingAmountSettlementDailyReport(Set<Instruction> instructions){
        return getReportingInstance(AMOUNT_SETTLEMENT_DAILY_REPORTING,BUY).generateReport(instructions);
    }

    public static StringBuilder generateIncomingRankingDailyReport(Set<Instruction> instructions){
        return getReportingInstance(RANKING_DAILY_REPORTING,SELL).generateReport(instructions);
    }

    public static StringBuilder generateOutgoingRankingDailyReport(Set<Instruction> instructions){
        return getReportingInstance(RANKING_DAILY_REPORTING,BUY).generateReport(instructions);
    }

    public static void generateDailyReporting(Set<Instruction> instructions){
        StringBuilder reportContent = new StringBuilder();
        reportContent
            .append(generateIncomingAmountSettlementDailyReport(instructions))
            .append(generateOutgoingAmountSettlementDailyReport(instructions))
            .append(generateIncomingRankingDailyReport(instructions))
            .append(generateOutgoingRankingDailyReport(instructions));
        System.out.println(reportContent);
    }
}
