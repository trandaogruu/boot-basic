package com.example.demo.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "department")
public class DepartmentEntity extends Base {


    @Column
    private String deanName;

    @Column
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<ClassEntity> classes = new ArrayList<>();

    @PreRemove
    public void setStatusClassWhenDelete(){
        classes.forEach(temp -> temp.setStatus(false));
//        auto set false class when delete class
    }

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
