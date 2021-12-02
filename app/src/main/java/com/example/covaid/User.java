package com.example.covaid;

public class User {

    String Address,Name;
    long Phone;

    public User(){}

    public User(String address, String name, long phone) {
        Address = address;
        Name = name;
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getName() {
        return Name;
    }

    public long getPhone() {
        return Phone;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }
}
