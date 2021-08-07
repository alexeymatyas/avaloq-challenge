import { Component, Input } from '@angular/core';
import { Simulation } from 'src/model/Simulation';

@Component({
  selector: 'app-simulations',
  templateUrl: './simulations.component.html',
  styleUrls: ['./simulations.component.less']
})
export class SimulationsComponent {
  @Input() simulations?: Simulation[];
}
