package com.example.demo.model.in;

public class UpdatePasswordIn {

    private String passwordOld;

    private String passwordNew;

    public UpdatePasswordIn( String passwordOld, String passwordNew) {

        this.passwordOld = passwordOld;
        this.passwordNew = passwordNew;
    }


    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }
}
