import { TestBed } from '@angular/core/testing';

import { DiceRollSimulationService } from './dice-roll-simulation.service';

describe('DiceRollSimulationService', () => {
  let service: DiceRollSimulationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiceRollSimulationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
