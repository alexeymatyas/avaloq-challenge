import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { StatisticsByDiceAndSideNumber } from 'src/model/StatisticsByDiceAndSideNumber';
import { DistributionByDiceAndSideNumber } from 'src/model/DistributionByDiceAndSideNumber';

@Injectable({
  providedIn: 'root'
})
export class DiceRollStatisticsService {
  private baseUrl = '/api/dice-roll-statistics';

  constructor(private http: HttpClient) { }

  getStatisticsByDiceAndSideNumber(): Observable<StatisticsByDiceAndSideNumber[]> {
    return this.http.get<StatisticsByDiceAndSideNumber[]>(this.baseUrl);
  }

  getDistributionByDiceAndSideNumber(diceNum: number, diceSideNum: number): Observable<DistributionByDiceAndSideNumber> {
    return this.http.get<DistributionByDiceAndSideNumber>(`${this.baseUrl}/${diceNum}-${diceSideNum}`);
  }
}
