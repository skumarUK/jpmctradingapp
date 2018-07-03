/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy.ranking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import co.uk.jp.trading.model.EntityRank;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.ranking.IRankingService;
import co.uk.jp.trading.service.ranking.impl.RankingServiceImpl;
import co.uk.jp.trading.strategy.reportingstrategy.ReportGenerator;

public abstract class RankingReport extends ReportGenerator {

    @Override public  Map<LocalDate, LinkedList<EntityRank>> getReportInstructions(Set<Instruction> instructions) {
        IRankingService rankingService = new RankingServiceImpl();
        return rankingService.rankInstructionsBySettlementDate(instructions,getInstructionsPredicate());
    }

    @Override protected StringBuilder getReportContent(Map <?, ?> reportData) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append(getReportHeader());
        reportContent.append(getReportBody(reportData));
        return reportContent;
    }

   private StringBuilder getReportBody(Map<?, ?> reportData) {
            StringBuilder reportContent = new StringBuilder();
            for (LocalDate date : ((Set<LocalDate>)reportData.keySet())) {
            for (EntityRank rank : ((LinkedList<EntityRank>)reportData.get(date))) {
                reportContent
                    .append(date).append("   |      ")
                    .append(rank.getRank()).append("     |    ")
                    .append(rank.getEntity()).append("\n");
            }
        }
     return reportContent;
    }
}
