package com.deviget.api.minesweep.services;

import com.deviget.api.minesweep.entities.IEntity;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class RestService <T extends IEntity> implements IRestService <T> {

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public T create(int a, int b, int c) {
        return null;
    }
}
