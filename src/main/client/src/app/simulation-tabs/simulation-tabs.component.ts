import { Component, Input } from '@angular/core';
import { Simulation } from 'src/model/Simulation';
import { StatisticsByDiceAndSideNumber } from 'src/model/StatisticsByDiceAndSideNumber';

@Component({
  selector: 'app-simulation-tabs',
  templateUrl: './simulation-tabs.component.html',
  styleUrls: ['./simulation-tabs.component.less']
})
export class SimulationTabsComponent {
  @Input() simulations?: Simulation[];
  @Input() statistics?: StatisticsByDiceAndSideNumber[];
}
