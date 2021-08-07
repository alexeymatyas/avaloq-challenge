import { Component } from '@angular/core';
import { Simulation } from 'src/model/Simulation';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  simulations: Simulation[] = [];

  addSimulation(simulation: Simulation): void {
    this.simulations.push(simulation);
  }
}
