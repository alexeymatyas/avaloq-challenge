package com.alekseimatias.avaloqchallenge.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public static int roll(int sideNum) {
        return ThreadLocalRandom.current().nextInt(1, sideNum);
    }
}
