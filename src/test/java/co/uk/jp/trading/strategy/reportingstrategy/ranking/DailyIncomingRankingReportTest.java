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
import co.uk.jp.trading.strategy.reportingstrategy.ranking.daily.DailyIncomingRankingReport;
import utils.TestUtils;

public class DailyIncomingRankingReportTest {

    private IReportGenerator reportGenerator;

    @Before
    public void setUp(){
        reportGenerator = DailyIncomingRankingReport.getInstance();
    }

    @Test
    public void when_IncomingRankingReport_Then_ReportHeader_Is_Ranking(){
        StringBuilder reportContent = reportGenerator.generateReport(TestUtils.getIncomingInstructionsDifferentSettlementDate());
        assertTrue(reportContent.toString().contains("Daily Incoming Ranking Report"));
    }

  }
