package com.alekseimatias.avaloqchallenge.rest;

import com.alekseimatias.avaloqchallenge.model.Simulation;
import com.alekseimatias.avaloqchallenge.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/dice-roll-simulations")
@Validated
public class DiceRollSimulationController {
    private final SimulationService simulationService;

    @Autowired
    public DiceRollSimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping
    public List<Simulation> getPreviousSimulations() {
        return simulationService.getPreviousSimulations();
    }

    @PostMapping
    public Simulation createNewSimulation(
            @RequestParam @Min(1) int diceNum,
            @RequestParam @Min(4) int diceSideNum,
            @RequestParam @Min(1) int rollNum) {
        return simulationService.getNewSimulationDistribution(diceNum, diceSideNum, rollNum);
    }
}
