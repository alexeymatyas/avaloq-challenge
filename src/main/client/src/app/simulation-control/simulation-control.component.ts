import { Component, Output, EventEmitter } from '@angular/core';
import { Simulation } from 'src/model/Simulation';
import { DiceRollSimulationService } from '../dice-roll-simulation.service';

@Component({
  selector: 'app-simulation-control',
  templateUrl: './simulation-control.component.html',
  styleUrls: ['./simulation-control.component.less']
})
export class SimulationControlComponent {
  diceNum: number = 3;
  diceSideNum: number = 6;
  rollNum: number = 100;

  @Output() onNewSimulation: EventEmitter<Simulation> = new EventEmitter();

  constructor(private diceRollSimulationService: DiceRollSimulationService) { }

  onRollButtonClick():void {
    this.diceRollSimulationService.getNewSimulation(this.diceNum, this.diceSideNum, this.rollNum)
      .subscribe(simulation => this.onNewSimulation.emit(simulation));
  }
}
