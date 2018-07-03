/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.ranking.impl;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import co.uk.jp.trading.model.EntityRank;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.ranking.IRankingService;

public class RankingServiceImpl implements IRankingService{

    @Override public Map<LocalDate, LinkedList<EntityRank>> rankInstructionsBySettlementDate(
        Set<Instruction> instructions, Predicate<Instruction> predicate) {

        final Map<LocalDate, LinkedList<EntityRank>> ranking = new HashMap<>();
        instructions.stream()
            .filter(predicate)
            .collect(groupingBy(Instruction::getSettlementDate, toSet()))
            .forEach((date, dailyInstructionSet) -> {
                final AtomicInteger rank = new AtomicInteger(1);
                final LinkedList<EntityRank> ranks = dailyInstructionSet.stream()
                    .sorted((a, b) -> b.getTradeAmount().compareTo(a.getTradeAmount()))
                    .map(instruction -> new EntityRank(instruction.getEntity(), rank.getAndIncrement(),  date))
                    .collect(toCollection(LinkedList::new));
                ranking.put(date, ranks);
            });
        return ranking;
    }
}
