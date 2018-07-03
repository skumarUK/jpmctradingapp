/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy.amountsettlement;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.uk.jp.trading.strategy.reportingstrategy.IReportGenerator;
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyOutgoingAmountSettlementReport;
import utils.TestUtils;

public class DailyOutgoingAmountSettlementReportTest {

    private IReportGenerator reportGenerator;

    @Before
    public void setUp(){
        reportGenerator = DailyOutgoingAmountSettlementReport.getInstance();
    }

    @Test
    public void when_OutgoingAmountSettlementReport_Then_ReportHeader_Is_OutgoingAmountSettlement(){
        StringBuilder reportContent = reportGenerator.generateReport(TestUtils.getOutgoingInstructionsSameSettlementDate());
        assertTrue(reportContent.toString().contains("Daily Outgoing AMOUNT SETTLEMENT Report"));
    }
}
