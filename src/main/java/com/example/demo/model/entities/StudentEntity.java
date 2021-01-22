package com.example.demo.model.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class StudentEntity extends Base {

    @Column
    private String accountName;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String fullName;

    @Column
    private Date birthday;

    @Column
    private boolean isMonitor;

    @Column
    private String avatar;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "class")
    private ClassEntity cclass;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission",
            joinColumns = @JoinColumn(name = "studentId", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "roleId", nullable = false))
    private Set<Role> roles = new HashSet<Role>();

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMonitor() {
        return isMonitor;
    }

    public void setMonitor(boolean monitor) {
        isMonitor = monitor;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ClassEntity getCclass() {
        return cclass;
    }

    public void setCclass(ClassEntity cclass) {
        this.cclass = cclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
