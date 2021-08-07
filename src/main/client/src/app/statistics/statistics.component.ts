import { Component, Input, OnChanges } from '@angular/core';
import { StatisticsByDiceAndSideNumber } from 'src/model/StatisticsByDiceAndSideNumber';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.less']
})
export class StatisticsComponent implements OnChanges {
  @Input() statistics?: StatisticsByDiceAndSideNumber[];
  selectedStatistics?: StatisticsByDiceAndSideNumber;

  onStatisticsRowClick(statistics: StatisticsByDiceAndSideNumber) {
    this.selectedStatistics = statistics;
  }

  ngOnChanges() {
    this.selectedStatistics = undefined;
  }
}
