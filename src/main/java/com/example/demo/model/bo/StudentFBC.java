package com.example.demo.model.bo;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class StudentFBC {

    private String fullName;
    private LocalDate birthday;
    private int lassId;
    private int page;
    private int limit;


    public StudentFBC(String fullName, LocalDate birthday, int lassId, int page, int limit) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.lassId = lassId;
        this.page = page;
        this.limit = limit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getLassId() {
        return lassId;
    }

    public void setLassId(int lassId) {
        this.lassId = lassId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
