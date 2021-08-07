package com.alekseimatias.avaloqchallenge.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimulationServiceTest {
    private static SimulationService underTest;

    @BeforeAll
    public static void setup() {
        underTest = new SimulationService();
    }

    @Test
    public void shouldSimulateDiceRoll() {
        // given
        int diceNum = 3;
        int diceSideNum = 6;
        int rollNum = 100;

        // when
        List<Integer> totals = underTest.getNewSimulationTotals(diceNum, diceSideNum, rollNum);

        // then
        assertThat(totals, is(notNullValue()));
        assertThat(totals.size(), is(equalTo(rollNum)));
    }
}
