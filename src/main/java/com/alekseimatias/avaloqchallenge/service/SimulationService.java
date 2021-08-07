package com.alekseimatias.avaloqchallenge.service;

import com.alekseimatias.avaloqchallenge.dao.SimulationDAO;
import com.alekseimatias.avaloqchallenge.model.Dice;
import com.alekseimatias.avaloqchallenge.model.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SimulationService {
    private SimulationDAO simulationDAO;

    @Autowired
    public SimulationService(SimulationDAO simulationDAO) {
        this.simulationDAO = simulationDAO;
    }

    protected List<Integer> getNewSimulationTotals(int diceNum, int diceSideNum, int rollNum) {
        List<Integer> totals = new ArrayList<>(rollNum);
        for(int rollRound = 0; rollRound < rollNum; rollRound++) {
            int total = 0;
            for(int dice = 0; dice < diceNum; dice++) {
                total += Dice.roll(diceSideNum);
            }
            totals.add(total);
        }

        return  totals;
    }

    public Simulation getNewSimulationDistribution(int diceNum, int diceSideNum, int rollNum) {
        List<Integer> totals = getNewSimulationTotals(diceNum, diceSideNum, rollNum);

        Map<Integer, Long> totalsDistribution = totals.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Simulation simulation = new Simulation(diceNum, diceSideNum, rollNum, totalsDistribution);
        simulationDAO.save(simulation);
        return simulation;
    }

    public List<Simulation> getPreviousSimulations() {
        return simulationDAO.findAll();
    }
}
