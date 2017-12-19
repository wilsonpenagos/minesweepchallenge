package com.deviget.api.minesweep.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class GameGrid implements IEntity{

    public static final Integer MAX_ROWS = 100;
    public static final Integer MAX_COLS = 100;
    public static final Integer MAX_MINES = 100;

    private Integer rows;
    private Integer columns;
    private Integer mines;
    private List<GameCell> gameCells;

    public GameGrid(Integer rows, Integer columns, Integer mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        //TODO: Logic that fills the gameCells list;
        this.gameCells = new ArrayList<>();
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getMines() {
        return mines;
    }

    public List<GameCell> getGameCells() {
        return gameCells;
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
