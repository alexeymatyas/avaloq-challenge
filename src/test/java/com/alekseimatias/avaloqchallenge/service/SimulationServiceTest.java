package com.alekseimatias.avaloqchallenge.service;

import com.alekseimatias.avaloqchallenge.dao.SimulationDAO;
import com.alekseimatias.avaloqchallenge.model.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

public class SimulationServiceTest {
    private SimulationService underTest;

    @BeforeEach
    public void setup() {
        SimulationDAO simulationDAOMock = mock(SimulationDAO.class);
        underTest = new SimulationService(simulationDAOMock);
    }

    @Test
    public void shouldSimulateDiceRoll() {
        // given
        int diceNum = 3;
        int diceSideNum = 6;
        int rollNum = 100;

        // when
        Simulation simulation = underTest.getNewSimulationDistribution(diceNum, diceSideNum, rollNum);

        // then
        assertThat(simulation.getTotalsDistribution(), is(notNullValue()));
    }
}
