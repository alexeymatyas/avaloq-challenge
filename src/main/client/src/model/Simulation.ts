export interface Simulation {
  diceNum: number;
  diceSideNum: number;
  rollNum: number;
  totalsDistribution: Record<string, number>;
}
