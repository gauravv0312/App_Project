package com.example.recyclerview;

public class model {
    String fname,email,phone;


    public model() {
    }

    public model(String fname, String email, String phone) {
        this.fname = fname;
        this.email = email;
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
