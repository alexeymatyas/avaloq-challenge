package com.alekseimatias.avaloqchallenge.rest;

import com.alekseimatias.avaloqchallenge.model.DistributionByDiceAndSideNumber;
import com.alekseimatias.avaloqchallenge.model.StatisticsByDiceAndSideNumber;
import com.alekseimatias.avaloqchallenge.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dice-roll-statistics")
public class DiceRollStatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public DiceRollStatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public List<StatisticsByDiceAndSideNumber> getStatistics() {
        return statisticsService.getStatisticsByDiceAndSideNumber();
    }

    @GetMapping(value = "/{diceNum}-{diceSideNum}")
    public DistributionByDiceAndSideNumber getDistributionByDiceAndSideNumber(
            @PathVariable int diceNum, @PathVariable int diceSideNum) {
        return statisticsService.getDistributionByDiceAndSideNumber(diceNum, diceSideNum);
    }
}
