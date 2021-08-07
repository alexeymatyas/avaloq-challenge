import { TestBed } from '@angular/core/testing';

import { DiceRollStatisticsService } from './dice-roll-statistics.service';

describe('DiceRollStatisticsService', () => {
  let service: DiceRollStatisticsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiceRollStatisticsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
