package com.deviget.api.minesweep.entities;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class GameCell implements IEntity{

    private Coordinate coordinate;
    private Boolean revealed;
    //-1 for a mine, 0 for empty, 1-8 for digit
    private Integer value;

    public GameCell(Coordinate coordinate, Boolean revealed, Integer value) {
        this.coordinate = coordinate;
        this.revealed = revealed;
        this.value = value;
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
