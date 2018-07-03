/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy.ranking;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.uk.jp.trading.strategy.reportingstrategy.IReportGenerator;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyOutgoingRankingReport;
import utils.TestUtils;

public class DailyOutgoingRankingReportTest {

    private IReportGenerator reportGenerator;

    @Before
    public void setUp(){
        reportGenerator = DailyOutgoingRankingReport.getInstance();
    }

    @Test
    public void when_OutgoingRankingReport_Then_ReportHeader_Is_OutgoingRanking(){
        StringBuilder reportContent = reportGenerator.generateReport(TestUtils.getOutgoingInstructionsSameSettlementDate());
        assertTrue(reportContent.toString().contains("Daily Outgoing Ranking Report"));
    }
}
