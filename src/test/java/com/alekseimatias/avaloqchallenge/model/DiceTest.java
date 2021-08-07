package com.alekseimatias.avaloqchallenge.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DiceTest {

    @Test
    public void shouldRoll() {
        // given
        int sideNum = 4;

        // when
        int side = Dice.roll(sideNum);

        // then
        assertThat(side, is(greaterThan(0)));
        assertThat(side, is(lessThanOrEqualTo(sideNum)));
    }
}
