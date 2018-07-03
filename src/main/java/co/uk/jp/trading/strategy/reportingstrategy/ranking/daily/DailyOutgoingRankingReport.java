package co.uk.jp.trading.strategy.reportingstrategy.ranking.daily;

import static co.uk.jp.trading.constants.Reporting.DAILY_OUTGOING_RANKING_REPORT_HEADER_LINE2;
import static co.uk.jp.trading.constants.Reporting.DAILY_RANKING_REPORT_HEADER_LINE4;
import static co.uk.jp.trading.constants.Reporting.REPORT_HEADER_BLANK_LINE;

import java.util.function.Predicate;

import co.uk.jp.trading.constants.Predicates;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.strategy.reportingstrategy.ranking.RankingReport;

public class DailyOutgoingRankingReport extends RankingReport {

    private static DailyOutgoingRankingReport instance = null;

    private DailyOutgoingRankingReport(){
        super();
    }
    public static DailyOutgoingRankingReport getInstance() {
        if (instance == null) {
            instance = new DailyOutgoingRankingReport();
        }
        return instance;
    }
    @Override protected Predicate <Instruction> getInstructionsPredicate() {
        return Predicates.OUTGOING_INSTRUCTIONS_PREDICATE;
    }

    @Override protected StringBuilder getReportHeader() {
        return buildReportHeader();
    }

    private StringBuilder buildReportHeader(){
        StringBuilder reportHeader = new StringBuilder();
        return reportHeader
            .append(REPORT_HEADER_BLANK_LINE)
            .append(DAILY_OUTGOING_RANKING_REPORT_HEADER_LINE2)
            .append(REPORT_HEADER_BLANK_LINE)
            .append(DAILY_RANKING_REPORT_HEADER_LINE4);
    }
}
