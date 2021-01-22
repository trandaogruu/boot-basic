package com.example.demo.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
public class ClassEntity extends Base {

    @Column
    private String homeroomTeacherName;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "department")
    private DepartmentEntity department;


    @JsonIgnore
    @OneToMany(mappedBy = "cclass")
    private List<StudentEntity> students = new ArrayList<>();


    @PreRemove
    public void setStatusClassWhenDelete(){
        students.forEach(temp -> temp.setStatus(false));
//        auto set false class when delete class
    }


    public String getHomeroomTeacherName() {
        return homeroomTeacherName;
    }

    public void setHomeroomTeacherName(String homeroomTeacherName) {
        this.homeroomTeacherName = homeroomTeacherName;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
