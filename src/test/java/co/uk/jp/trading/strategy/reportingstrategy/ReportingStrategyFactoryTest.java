/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.uk.jp.trading.constants.ReportingTypes;
import co.uk.jp.trading.constants.TradingAction;
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyIncomingAmountSettlementReport;
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyOutgoingAmountSettlementReport;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyIncomingRankingReport;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyOutgoingRankingReport;

public class ReportingStrategyFactoryTest {

    private IReportGenerator reportGenerator;

     @Test
    public void when_GivenReportName_Is_RankingReport_And_TradingAction_BUY_Then_OutGoingRankingReport(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(ReportingTypes.RANKING_DAILY_REPORTING,
            TradingAction.BUY);
        assertTrue(reportGenerator instanceof DailyOutgoingRankingReport);
    }

    @Test
    public void when_GivenReportName_Is_AmountSettlement_And_TradingAction_BUY_Then_OutgoingAmountSettlementReport(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(ReportingTypes.AMOUNT_SETTLEMENT_DAILY_REPORTING,
            TradingAction.BUY);
        assertTrue(reportGenerator instanceof DailyOutgoingAmountSettlementReport);
    }

    @Test
    public void when_GivenReportName_Is_RankingReport_And_TradingAction_SELL_Then_IncomingRankingReport(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(ReportingTypes.RANKING_DAILY_REPORTING,
            TradingAction.SELL);
        assertTrue(reportGenerator instanceof DailyIncomingRankingReport);
    }

    @Test
    public void when_GivenReportName_Is_AmountSettlement_And_TradingAction_SELL_Then_IncomingAmountSettlementReport(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(ReportingTypes.AMOUNT_SETTLEMENT_DAILY_REPORTING,
            TradingAction.SELL);
        assertTrue(reportGenerator instanceof DailyIncomingAmountSettlementReport);
    }

    @Test
    public void when_GivenReportName_Is_AmountSettlement_And_TradingAction_Is_NULL_Then_IllegalArgumentException(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(ReportingTypes.AMOUNT_SETTLEMENT_DAILY_REPORTING,
            null);
        assertEquals(null,reportGenerator);
    }

    @Test
    public void when_GivenReportName_Is_NULL_And_TradingAction_SELL_Then_IllegalArgumentException(){
        reportGenerator = ReportingStrategyFactory.getReportingInstance(null,
            TradingAction.SELL);
        assertEquals(null,reportGenerator);
    }

}
