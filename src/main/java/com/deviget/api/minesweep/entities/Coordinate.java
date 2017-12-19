package com.deviget.api.minesweep.entities;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class Coordinate implements IEntity{

    private Integer xVal;
    private Integer yVal;

    public Coordinate(Integer xVal, Integer yVal) {
        this.xVal = xVal;
        this.yVal = yVal;
    }

    public Integer getxVal() {
        return xVal;
    }

    public void setxVal(Integer xVal) {
        this.xVal = xVal;
    }

    public Integer getyVal() {
        return yVal;
    }

    public void setyVal(Integer yVal) {
        this.yVal = yVal;
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
