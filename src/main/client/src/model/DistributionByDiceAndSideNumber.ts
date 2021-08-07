export interface DistributionByDiceAndSideNumber {
  diceNum: number;
  diceSideNum: number;
  totalSimulations: number;
  totalRolls: number;
  totalsDistribution: Record<number, number>;
}
