/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.ranking;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import co.uk.jp.trading.constants.Predicates;
import co.uk.jp.trading.model.EntityRank;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.ranking.impl.RankingServiceImpl;
import utils.TestUtils;


public class RankingServiceTest {

    private IRankingService rankingService;

    @Before
    public void setUp(){
        rankingService = new RankingServiceImpl();
    }

    @Test
    public void when_GivenInstructions_Perform_Ranking_For_Incoming_Predicate(){

        Set<Instruction> instructions = TestUtils.getIncomingInstructionsDifferentSettlementDate();
        Map<LocalDate, LinkedList<EntityRank>> rankedEntities =
            rankingService.rankInstructionsBySettlementDate(instructions, Predicates.INCOMING_INSTRUCTIONS_PREDICATE);
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 25)).size());
        assertEquals("E1",rankedEntities.get(LocalDate.of(2018, 6, 25)).get(0).getEntity());
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 25)).get(0).getRank());
        assertEquals(LocalDate.of(2018, 6, 25),rankedEntities.get(LocalDate.of(2018, 6, 25)).get(0).getDate());
        //Check all entities belong to same localDate
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 23)).size());
        assertEquals("E10",rankedEntities.get(LocalDate.of(2018, 6, 23)).get(0).getEntity());
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 23)).get(0).getRank());
        assertEquals(LocalDate.of(2018, 6, 23),rankedEntities.get(LocalDate.of(2018, 6, 23)).get(0).getDate());
   }

    @Test
    public void when_GivenInstructions_Perform_Ranking_For_Outgoing_Predicate(){

        Set<Instruction> instructions = TestUtils.getOutgoingInstructionsSameSettlementDate();
        Map<LocalDate, LinkedList<EntityRank>> rankedEntities =
            rankingService.rankInstructionsBySettlementDate(instructions, Predicates.OUTGOING_INSTRUCTIONS_PREDICATE);
        assertEquals(2,rankedEntities.get(LocalDate.of(2018, 6, 19)).size());
        //Check all entities belong to same localDate
        assertEquals("E2",rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getEntity());
        assertEquals(2,rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getRank());
        assertEquals(LocalDate.of(2018, 6, 19),rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getDate());

        assertEquals("E12",rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getEntity());
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getRank());
        assertEquals(LocalDate.of(2018, 6, 19),rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getDate());

    }

    @Test
    public void when_GivenInstructions_Perform_Ranking_For_Outgoing_Predicate_SameSettlementDate_SameEntityMultipleTimes(){

        Set<Instruction> instructions = TestUtils.getOutgoingInstructionsSameSettlementDateSameEntityMultipleTimes();
        Map<LocalDate, LinkedList<EntityRank>> rankedEntities =
            rankingService.rankInstructionsBySettlementDate(instructions, Predicates.OUTGOING_INSTRUCTIONS_PREDICATE);
        assertEquals(4,rankedEntities.get(LocalDate.of(2018, 6, 19)).size());
        //Check all entities belong to same localDate
        assertEquals("E12",rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getEntity());
        assertEquals(1,rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getRank());
        assertEquals(LocalDate.of(2018, 6, 19),rankedEntities.get(LocalDate.of(2018, 6, 19)).get(0).getDate());

        assertEquals("E2",rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getEntity());
        assertEquals(2,rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getRank());
        assertEquals(LocalDate.of(2018, 6, 19),rankedEntities.get(LocalDate.of(2018, 6, 19)).get(1).getDate());

    }
}
