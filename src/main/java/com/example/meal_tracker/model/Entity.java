package com.example.meal_tracker.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
@MappedSuperclass
public class Entity<IDtype extends Serializable> implements Serializable {
    private static final long serialVersionUID = 123456789L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private IDtype id;

    public IDtype getId() {return id;}
    public void setId(IDtype id) {this.id = id;}
}
