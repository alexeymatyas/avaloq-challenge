package com.alekseimatias.avaloqchallenge.model;

import com.alekseimatias.avaloqchallenge.dao.DistributionConverter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "simulations")
public class Simulation {
    @Id
    @GeneratedValue
    private int id;

    private int diceNum;
    private int diceSideNum;
    private int rollNum;

    @Lob
    @Convert(converter = DistributionConverter.class)
    private Map<Integer, Long> totalsDistribution;

    Simulation() {}

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
