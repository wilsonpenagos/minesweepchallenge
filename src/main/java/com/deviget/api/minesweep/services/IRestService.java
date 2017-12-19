package com.deviget.api.minesweep.services;

import com.deviget.api.minesweep.entities.IEntity;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public interface IRestService<T extends IEntity> {

    T save(T entity);
    T findOne(Long id);
    T create(int a, int b, int c);
}
