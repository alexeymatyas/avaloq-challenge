package com.alekseimatias.avaloqchallenge.model;

public class StatisticsByDiceAndSideNumber {
    private final int diceNum;
    private final int diceSideNum;
    private final long totalSimulations;
    private final long totalRolls;

    public StatisticsByDiceAndSideNumber(int diceNum, int diceSideNum, long totalSimulations, long totalRolls) {
        this.diceNum = diceNum;
        this.diceSideNum = diceSideNum;
        this.totalSimulations = totalSimulations;
        this.totalRolls = totalRolls;
    }

    public int getDiceNum() {
        return diceNum;
    }

    public int getDiceSideNum() {
        return diceSideNum;
    }

    public long getTotalSimulations() {
        return totalSimulations;
    }

    public long getTotalRolls() {
        return totalRolls;
    }
}
