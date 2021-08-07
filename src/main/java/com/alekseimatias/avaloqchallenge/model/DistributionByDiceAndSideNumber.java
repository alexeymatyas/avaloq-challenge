package com.alekseimatias.avaloqchallenge.model;

import java.math.BigDecimal;
import java.util.Map;

public class DistributionByDiceAndSideNumber {
    private final int diceNum;
    private final int diceSideNum;
    private final long totalSimulations;
    private final long totalRolls;
    private final Map<Integer, BigDecimal> totalsDistribution;

    public DistributionByDiceAndSideNumber(int diceNum, int diceSideNum, long totalSimulations, long totalRolls, Map<Integer, BigDecimal> totalsDistribution) {
        this.diceNum = diceNum;
        this.diceSideNum = diceSideNum;
        this.totalSimulations = totalSimulations;
        this.totalRolls = totalRolls;
        this.totalsDistribution = totalsDistribution;
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

    public Map<Integer, BigDecimal> getTotalsDistribution() {
        return totalsDistribution;
    }
}
