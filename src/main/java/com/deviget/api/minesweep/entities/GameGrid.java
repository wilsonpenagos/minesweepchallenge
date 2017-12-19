package com.deviget.api.minesweep.entities;

import com.deviget.api.minesweep.exceptions.ExceededGridValuesException;
import com.deviget.api.minesweep.exceptions.OutOfBoundsGridException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class GameGrid implements IEntity{

    public static final Integer MAX_ROWS = 50;
    public static final Integer MAX_COLS = 50;
    public static final Integer MAX_MINES = 25;

    private Integer rows;
    private Integer columns;
    private Integer mines;
    private HashMap<Coordinate, GameCell> gameCells;

    public GameGrid(Integer rows, Integer columns, Integer mines) throws ExceededGridValuesException{
        if (rows > MAX_ROWS || columns > MAX_COLS || mines > MAX_MINES){
            throw new ExceededGridValuesException();
        }
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.gameCells = fillGameCells();
    }

    private HashMap<Coordinate, GameCell> fillGameCells() {
        Random rand = new Random();
        HashMap<Coordinate, GameCell> result = new HashMap<>();
        for(int i = 0; i < mines; i++){
            int xRand = rand.nextInt(rows);
            int yRand = rand.nextInt(rows);
            Coordinate evalCoordinate = new Coordinate(xRand, yRand);
            if (!result.containsKey(evalCoordinate)){
                result.put(evalCoordinate, new GameCell(evalCoordinate, false, -1));
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; i++){
                Coordinate evalCoordinate = new Coordinate(i, j);
                if (!result.containsKey(evalCoordinate)){
                    List<Coordinate> neighbors = getNeighbors(evalCoordinate);
                    int value = 0;
                    for (Coordinate coord : neighbors){
                        if (result.get(coord).getValue().equals(-1)){
                                value++;
                        }
                    }
                    result.put(evalCoordinate, new GameCell(evalCoordinate, false, value));
                }
            }
        }
        return result;
    }

    private List<Coordinate> getNeighbors(Coordinate coord) {
        int xVal = coord.getxVal();
        int yVal = coord.getyVal();
        List<Coordinate> result = new ArrayList<>();
        // 0 . 1
        if (!(yVal + 1 >= columns)){
            result.add(new Coordinate(xVal, yVal + 1));
        }
        // 0 . -1
        if (!(yVal - 1 < 0)){
            result.add(new Coordinate(xVal, yVal - 1));
        }
        // 1 . 0
        if (!(xVal + 1 >= rows)){
            result.add(new Coordinate(xVal + 1, yVal));
        }
        // 1 . 1
        if (!(xVal + 1 >= rows) && !(yVal + 1 >= columns)){
            result.add(new Coordinate(xVal + 1, yVal +1));
        }
        // 1 . -1
        if (!(xVal + 1 >= rows) && !(yVal - 1 < 0)){
            result.add(new Coordinate(xVal + 1, yVal -1));
        }
        // -1 . 0
        if (!(xVal - 1 < 0)){
            result.add(new Coordinate(xVal - 1, yVal));
        }
        // -1 . 1
        if (!(xVal - 1 < 0) && !(yVal + 1 >= columns)){
            result.add(new Coordinate(xVal - 1, yVal +1));
        }
        // -1 . -1
        if (!(xVal - 1 < 0) && !(yVal - 1 < 0)){
            result.add(new Coordinate(xVal - 1, yVal -1));
        }
        return result;
    }

    public void reveal(Integer row, Integer col) throws OutOfBoundsGridException {
        Coordinate evalCoordinate = new Coordinate(row, col);
        if (!gameCells.containsKey(evalCoordinate)){
            throw new OutOfBoundsGridException();
        }
        GameCell gameCell =  gameCells.get(evalCoordinate);
        gameCell.setRevealed(true);
        if(gameCell.getValue().equals(0)){
            List<Coordinate> neighbors = getNeighbors(evalCoordinate);
            for (Coordinate coord : neighbors){
                GameCell neighborCell = gameCells.get(coord);
                if (!neighborCell.getValue().equals(-1) && !neighborCell.getRevealed()){
                    reveal(coord.getxVal(), coord.getyVal());
                }
            }
        }
    }

    public boolean isCleanGrid() {
        for(Coordinate coord : gameCells.keySet()){
            GameCell curr = gameCells.get(coord);
            if(!curr.getValue().equals(-1) && !curr.getRevealed()){
                return false;
            }
        }
        return true;
    }

    public boolean hasReveledMine() {
        for(Coordinate coord : gameCells.keySet()){
            GameCell curr = gameCells.get(coord);
            if(curr.getRevealed() && curr.getValue().equals(-1)){
                return true;
            }
        }
        return false;
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

    public HashMap<Coordinate, GameCell> getGameCells() {
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
