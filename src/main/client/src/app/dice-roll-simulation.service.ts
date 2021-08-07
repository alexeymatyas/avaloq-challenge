import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Simulation } from '../model/Simulation';

@Injectable({
  providedIn: 'root'
})
export class DiceRollSimulationService {
  private baseUrl = '/api/dice-roll-simulations';

  constructor(private http: HttpClient) { }

  getNewSimulation(diceNum: number, diceSideNum: number, rollNum: number): Observable<Simulation> {
    return this.http.post<Simulation>(this.baseUrl, null, {
      params: {
        diceNum,
        diceSideNum,
        rollNum,
      },
    })
  }
}
