package com.deviget.api.minesweep.entities;

import com.deviget.api.minesweep.exceptions.ExceededGridValuesException;

import java.time.LocalDateTime;

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
