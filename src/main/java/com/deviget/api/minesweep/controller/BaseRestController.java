package com.deviget.api.minesweep.controller;

import com.deviget.api.minesweep.entities.IEntity;
import com.deviget.api.minesweep.services.IRestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wilson.penagos on 18/12/17.
 */
public class BaseRestController<T extends IEntity> extends BaseController {

    public BaseRestController(IRestService service){
        this.service = service;
    }

    public IRestService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable Long id) {
        return this.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody T entity){
        service.save(entity);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable("id") Long id, @RequestBody T entity)  {
        T original = this.findById(id);
        return (T) service.save(entity);
    }

    private T findById(Long id){
        T entity = (T) service.findOne(id);
        return entity;
    }

}