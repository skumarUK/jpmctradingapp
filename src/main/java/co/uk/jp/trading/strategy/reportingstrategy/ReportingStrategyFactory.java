/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy;

import static co.uk.jp.trading.constants.ReportingTypes.AMOUNT_SETTLEMENT_DAILY_REPORTING;
import static co.uk.jp.trading.constants.ReportingTypes.RANKING_DAILY_REPORTING;

import co.uk.jp.trading.constants.TradingAction;
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyIncomingAmountSettlementReport;
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyOutgoingAmountSettlementReport;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyIncomingRankingReport;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyOutgoingRankingReport;

public class ReportingStrategyFactory {

    /**
     * This method returns ReportingImplementation based on the reportName and tradingAdvice
     * i.e. DailyRankingReport, BUY this will return object of DailyOutgoingRankingReport.
     * If there is no reportName is configured for strategy it returns NULL.
     * If there is no matching case found of enum type of TradingAction it @throws
     * IllegalArgumentException {@link IllegalArgumentException}
     *
     * @param reportName {@link co.uk.jp.trading.constants.ReportingTypes}
     * @param tradingAction {@link TradingAction}
     * @return IReportGenerator {@link IReportGenerator}
     * @throws IllegalArgumentException {@link IllegalArgumentException} when there is no matching case found
     * of enum type ofTradingAction.
     */

public static IReportGenerator getReportingInstance(String reportName, TradingAction tradingAction){
    IReportGenerator reportGenerator = null;
    if(tradingAction!=null) {
        switch (tradingAction) {
            case BUY:
                if (RANKING_DAILY_REPORTING.equalsIgnoreCase(reportName)) {
                    reportGenerator = DailyOutgoingRankingReport.getInstance();
                } else if (AMOUNT_SETTLEMENT_DAILY_REPORTING.equalsIgnoreCase(reportName)) {
                    reportGenerator = DailyOutgoingAmountSettlementReport.getInstance();
                }
                break;
            case SELL:
                if (RANKING_DAILY_REPORTING.equalsIgnoreCase(reportName)) {
                    reportGenerator = DailyIncomingRankingReport.getInstance();
                } else if (AMOUNT_SETTLEMENT_DAILY_REPORTING.equalsIgnoreCase(reportName)) {
                    reportGenerator = DailyIncomingAmountSettlementReport.getInstance();
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown trading action " + tradingAction);
        }
    }
    return reportGenerator;
}

}
