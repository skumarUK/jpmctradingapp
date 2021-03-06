/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy.ranking.daily;

import static co.uk.jp.trading.constants.Reporting.DAILY_INCOMING_RANKING_REPORT_HEADER_LINE2;
import static co.uk.jp.trading.constants.Reporting.DAILY_RANKING_REPORT_HEADER_LINE4;
import static co.uk.jp.trading.constants.Reporting.REPORT_HEADER_BLANK_LINE;

import java.util.function.Predicate;

import co.uk.jp.trading.constants.Predicates;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.RankingReport;

public class DailyIncomingRankingReport extends RankingReport {

    private static DailyIncomingRankingReport instance = null;

    private DailyIncomingRankingReport(){
        super();
    }


    public static DailyIncomingRankingReport getInstance() {
        if (instance == null) {
            instance = new DailyIncomingRankingReport();
        }
        return instance;
    }

    @Override protected Predicate <Instruction> getInstructionsPredicate() {
        return Predicates.INCOMING_INSTRUCTIONS_PREDICATE;
    }

    @Override protected StringBuilder getReportHeader() {
        return buildReportHeader();
    }

    private StringBuilder buildReportHeader(){
        StringBuilder reportHeader = new StringBuilder();
        return reportHeader
            .append(REPORT_HEADER_BLANK_LINE)
            .append(DAILY_INCOMING_RANKING_REPORT_HEADER_LINE2)
            .append(REPORT_HEADER_BLANK_LINE)
            .append(DAILY_RANKING_REPORT_HEADER_LINE4);
    }
}
