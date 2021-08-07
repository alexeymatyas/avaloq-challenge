import { Component, OnInit } from '@angular/core';
import { Simulation } from 'src/model/Simulation';
import { StatisticsByDiceAndSideNumber } from 'src/model/StatisticsByDiceAndSideNumber';
import { DiceRollSimulationService } from './dice-roll-simulation.service';
import { DiceRollStatisticsService } from './dice-roll-statistics.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  simulations: Simulation[] = [];
  statistics: StatisticsByDiceAndSideNumber[] = [];

  constructor(private diceRollSimulationService: DiceRollSimulationService, private diceRollStatisticsService: DiceRollStatisticsService) {}

  loadSimulations(): void {
    this.diceRollSimulationService.getPreviousSimulations()
      .subscribe(simulations => this.simulations = simulations);
  }

  loadStatistics(): void {
    this.diceRollStatisticsService.getStatisticsByDiceAndSideNumber()
      .subscribe(statistics => this.statistics = statistics);
  }

  addSimulation(simulation: Simulation): void {
    this.simulations.push(simulation);
    this.loadSimulations();
    this.loadStatistics();
  }

  ngOnInit() {
    this.loadSimulations();
    this.loadStatistics();
  }
}
