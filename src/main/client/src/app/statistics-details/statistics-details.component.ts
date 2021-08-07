import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DistributionByDiceAndSideNumber } from 'src/model/DistributionByDiceAndSideNumber';
import { StatisticsByDiceAndSideNumber } from 'src/model/StatisticsByDiceAndSideNumber';
import { DiceRollStatisticsService } from '../dice-roll-statistics.service';

@Component({
  selector: 'app-statistics-details',
  templateUrl: './statistics-details.component.html',
  styleUrls: ['./statistics-details.component.less']
})
export class StatisticsDetailsComponent implements OnInit, OnChanges {
  @Input() statistics?: StatisticsByDiceAndSideNumber;
  distribution?: DistributionByDiceAndSideNumber;

  constructor(private diceRollStatisticsService: DiceRollStatisticsService, private modalService: NgbModal) {}

  loadDetails() {
    if(this.statistics) {
      this.diceRollStatisticsService.getDistributionByDiceAndSideNumber(this.statistics?.diceNum, this.statistics?.diceSideNum)
      .subscribe(distribution => this.distribution = distribution);
    }
  }

  ngOnInit() {
    this.loadDetails();
  }

  ngOnChanges() {
    this.loadDetails();
  }
}
