package com.alekseimatias.avaloqchallenge.model;

import java.util.Map;

public class Simulation {
    private final int diceNum;
    private final int diceSideNum;
    private final int rollNum;
    private final Map<Integer, Long> totalsDistribution;

    public Simulation(int diceNum, int diceSideNum, int rollNum, Map<Integer, Long> totalsDistribution) {
        this.diceNum = diceNum;
        this.diceSideNum = diceSideNum;
        this.rollNum = rollNum;
        this.totalsDistribution = totalsDistribution;
    }

    public int getDiceNum() {
        return diceNum;
    }

    public int getDiceSideNum() {
        return diceSideNum;
    }

    public int getRollNum() {
        return rollNum;
    }

    public Map<Integer, Long> getTotalsDistribution() {
        return totalsDistribution;
    }
}
