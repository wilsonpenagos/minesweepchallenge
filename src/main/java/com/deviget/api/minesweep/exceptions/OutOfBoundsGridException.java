package com.deviget.api.minesweep.exceptions;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class OutOfBoundsGridException extends Exception {

    public OutOfBoundsGridException(){
        super("The received coordinates do not exist.");
    }

}