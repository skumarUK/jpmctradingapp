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
import co.uk.jp.trading.strategy.reportingstrategy.amountsettlement.daily.DailyIncomingAmountSettlementReport;
import utils.TestUtils;

public class DailyIncomingAmountSettlementReportTest {

    private IReportGenerator reportGenerator;

    @Before
    public void setUp(){
        reportGenerator = DailyIncomingAmountSettlementReport.getInstance();
    }

    @Test
    public void when_IncomingAmountSettlementReport_Then_ReportHeader_Is_IncomingAmountSettlement(){
        StringBuilder reportContent = reportGenerator.generateReport(TestUtils.getIncomingInstructionsDifferentSettlementDate());
        assertTrue(reportContent.toString().contains("Daily Incoming AMOUNT SETTLEMENT Report"));
    }

  }
