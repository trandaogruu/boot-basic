package com.example.demo.model.in;


import java.util.ArrayList;
import java.util.List;

public class ClassIn {


    private int id;

    private String name;

    private List<Integer> studentEntities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<Integer> studentEntities) {
        this.studentEntities = studentEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
