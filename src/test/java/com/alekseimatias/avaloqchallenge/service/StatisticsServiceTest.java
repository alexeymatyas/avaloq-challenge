package com.alekseimatias.avaloqchallenge.service;

import com.alekseimatias.avaloqchallenge.dao.SimulationDAO;
import com.alekseimatias.avaloqchallenge.model.DistributionByDiceAndSideNumber;
import com.alekseimatias.avaloqchallenge.model.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {
    SimulationDAO simulationDAOMock;

    private StatisticsService underTest;

    @BeforeEach
    public void setup() {
        simulationDAOMock = mock(SimulationDAO.class);
        underTest = new StatisticsService(simulationDAOMock);
    }

    @Test
    public void shouldCalculateDistributionByDiceAndSideNumber() {
        // given
        int diceNum = 3;
        int diceSideNum = 6;
        int rollNum = 10;

        Map<Integer, Long> totalsDistribution = new HashMap<>();
        totalsDistribution.put(10, 4L);
        totalsDistribution.put(11, 4L);
        totalsDistribution.put(12, 2L);
        Simulation simulation = new Simulation(diceNum, diceSideNum, rollNum, totalsDistribution);

        when(simulationDAOMock.findByDiceNumAndDiceSideNum(diceNum, diceSideNum)).thenReturn(Arrays.asList(simulation));
        when(simulationDAOMock.getTotalRolls()).thenReturn((long) rollNum);

        // when
        DistributionByDiceAndSideNumber distribution = underTest.getDistributionByDiceAndSideNumber(diceNum, diceSideNum);

        // then
        assertThat(distribution.getTotalsDistribution().get(10), is(equalTo(new BigDecimal("40.00"))));
        assertThat(distribution.getTotalsDistribution().get(11), is(equalTo(new BigDecimal("40.00"))));
        assertThat(distribution.getTotalsDistribution().get(12), is(equalTo(new BigDecimal("20.00"))));
    }
}
