package com.deviget.api.minesweep.exceptions;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class ExceededGridValuesException extends Exception {

    public ExceededGridValuesException(){
        super("One of the intended values for the game exced the allowed value.");
    }

}