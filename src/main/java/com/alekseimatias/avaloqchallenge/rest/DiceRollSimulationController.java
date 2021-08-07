package com.alekseimatias.avaloqchallenge.rest;

import com.alekseimatias.avaloqchallenge.model.Simulation;
import com.alekseimatias.avaloqchallenge.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/dice-roll-simulations")
@Validated
public class DiceRollSimulationController {
    private final SimulationService simulationService;

    @Autowired
    public DiceRollSimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping()
    public Simulation createNewSimulation(
            @RequestParam @Min(1) int diceNum,
            @RequestParam @Min(4) int diceSideNum,
            @RequestParam @Min(1) int rollNum) {
        return simulationService.getNewSimulationDistribution(diceNum, diceSideNum, rollNum);
    }
}
