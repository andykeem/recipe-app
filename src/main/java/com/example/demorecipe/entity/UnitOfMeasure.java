package com.example.demorecipe.entity;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UnitOfMeasure{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
