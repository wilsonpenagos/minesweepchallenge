package com.deviget.api.minesweep.response;

import com.deviget.api.minesweep.entities.IEntity;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class Response {
    private Result result;
    private IEntity message;

    public Response(Result result, IEntity message){
        this.result = result;
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public IEntity getMessage() {
        return message;
    }

    public void setMessage(IEntity message) {
        this.message = message;
    }

}
