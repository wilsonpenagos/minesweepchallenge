package com.deviget.api.minesweep.entities;

import com.deviget.api.minesweep.exceptions.ExceededGridValuesException;
import com.deviget.api.minesweep.exceptions.OutOfBoundsGridException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class MineSweeper implements IEntity {

    private GameGrid gameGrid;
    private GameStatus gameStatus;
    private Integer elapsedSeconds;
    private LocalDateTime activeTime;
    private LocalDateTime stopTime;

    public MineSweeper(Long id, Integer rows, Integer cols, Integer mines) throws ExceededGridValuesException {
        gameGrid = new GameGrid(rows, cols, mines);
        elapsedSeconds = new Integer(0);
        activeTime = LocalDateTime.now();
        gameStatus = GameStatus.ACTIVE;
        this.id = id;
    }

    public void reveal(Integer row, Integer col) throws OutOfBoundsGridException {
        gameGrid.reveal(row, col);
        if (gameGrid.hasReveledMine()){
            gameStatus = GameStatus.LOSS;
        }
        else if(gameGrid.isCleanGrid()){
            gameStatus = GameStatus.WON;
        }
        actTime();
    }

    private void actTime() {
        LocalDateTime curr = LocalDateTime.now();
        Long seconds = ChronoUnit.SECONDS.between(activeTime, curr);
        elapsedSeconds += seconds.intValue();
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Integer getElapsedSeconds() {
        return elapsedSeconds;
    }

    public LocalDateTime getActiveTime() {
        return activeTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    // Applies to every entity in the model, for future persistence implementation.
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


}
