package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.Entity;

import java.io.Serializable;
import java.util.List;

public interface IRepository<ID extends Serializable, E extends Entity<ID>> {
    public E findById(ID id);
    public List<E> findAll();
    public void save(E entity);
    public void delete(ID id);
    public void update(E entity);
}
