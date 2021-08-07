package com.alekseimatias.avaloqchallenge.service;

import com.alekseimatias.avaloqchallenge.dao.SimulationDAO;
import com.alekseimatias.avaloqchallenge.model.DistributionByDiceAndSideNumber;
import com.alekseimatias.avaloqchallenge.model.Simulation;
import com.alekseimatias.avaloqchallenge.model.StatisticsByDiceAndSideNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {
    private final SimulationDAO simulationDAO;

    @Autowired
    public StatisticsService(SimulationDAO simulationDAO) {
        this.simulationDAO = simulationDAO;
    }

    public List<StatisticsByDiceAndSideNumber> getStatisticsByDiceAndSideNumber() {
        return simulationDAO.getStatisticsByDiceAndSideNumber();
    }

    public DistributionByDiceAndSideNumber getDistributionByDiceAndSideNumber(int diceNum, int diceSideNum) {
        List<Simulation> simulations = simulationDAO.findByDiceNumAndDiceSideNum(diceNum, diceSideNum);
        long totalRolls = simulationDAO.getTotalRolls();

        Map<Integer, BigDecimal> distribution = new HashMap<>();
        for(int diceSidesSum = diceNum; diceSidesSum <= diceNum * diceSideNum; diceSidesSum++) {
            int totalRollsByDiceSideSum = 0;
            for(Simulation simulation: simulations) {
                Long rollNum = simulation.getTotalsDistribution().get(diceSidesSum);
                if(rollNum != null) {
                    totalRollsByDiceSideSum += simulation.getTotalsDistribution().get(diceSidesSum);
                }
            }

            BigDecimal relativePercentage = BigDecimal.valueOf(totalRollsByDiceSideSum)
                    .divide(BigDecimal.valueOf(totalRolls), 2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));

            distribution.put(diceSidesSum, relativePercentage);
        }

        return new DistributionByDiceAndSideNumber(diceNum, diceSideNum, simulationDAO.count(), totalRolls, distribution);
    }
}
