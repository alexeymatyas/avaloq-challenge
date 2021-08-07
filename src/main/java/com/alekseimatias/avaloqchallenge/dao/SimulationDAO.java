package com.alekseimatias.avaloqchallenge.dao;

import com.alekseimatias.avaloqchallenge.model.Simulation;
import com.alekseimatias.avaloqchallenge.model.StatisticsByDiceAndSideNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimulationDAO extends JpaRepository<Simulation, Long> {
    @Query("SELECT new com.alekseimatias.avaloqchallenge.model.StatisticsByDiceAndSideNumber(diceNum, diceSideNum, count(*), sum(rollNum)) " +
            "FROM Simulation GROUP BY diceNum, diceSideNum")
    List<StatisticsByDiceAndSideNumber> getStatisticsByDiceAndSideNumber();

    @Query("SELECT sum(rollNum) FROM Simulation")
    Long getTotalRolls();

    List<Simulation> findByDiceNumAndDiceSideNum(int diceNum, int diceSideNum);
}
