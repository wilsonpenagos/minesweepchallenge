package com.deviget.api.minesweep.response;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class Result {
    private Status status;
    private String message;

    public Result(Status status, String message){
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
