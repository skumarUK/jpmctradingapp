/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.ranking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import co.uk.jp.trading.model.EntityRank;
import co.uk.jp.trading.model.Instruction;

public interface IRankingService {

    /**
     * Firstly, This method does filter given instructions based on provided Predicate<Instruction> {@link Predicate}.
     * i.e. If Predicate is only for Outgoing instructions then it will filter on TradingAction.BUY and
     * applying ranking only on the BUY instruction.
     * i.e. If Predicate is only for Incoming instructions then it will filter on TradingAction.SELL and
     * applying ranking only on the SELL instruction.
     * This method does rank service on given settlement Date. If any entity trading amount is higher than others will be assigned higher rank.
     * i.e. Entity A does trading of 100 USD amount on 01 July 2018.
     * Entity B does trading of 150 USD amount on 01 July 2018.
     * Given Rank on 01 July2018 would be below.
     * Entity A - Rank is 2.
     * Entity B - Rank is 1.
     *
     * @param instructions accepts Set<Instruction>{@link Instruction} of various settlement dates.
     * @param predicate is filter on given Set<Instruction> {@link Instruction} i.e. Outgoing {@link co.uk.jp.trading.constants.TradingAction}
     * @return Map of LinkedList<EntityRank> {@link EntityRank} for given SettlementDate as Key value.
     */
    Map<LocalDate, LinkedList<EntityRank>> rankInstructionsBySettlementDate(Set<Instruction> instructions, Predicate<Instruction> predicate);
}
