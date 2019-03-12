package com.stackroute.MovieApplicationService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie{
    @Id
    private int id;
    private String name;
    private int length;
    private  String type;

    public Movie() {
    }

    public Movie(int id, String name, int length, String type) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
