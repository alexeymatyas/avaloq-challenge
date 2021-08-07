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

  getPreviousSimulations(): Observable<Simulation[]> {
    return this.http.get<Simulation[]>(this.baseUrl);
  }

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
