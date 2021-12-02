package com.example.covaid;

public class UserDetails {
    private String username;
    private String phonenumber;
    private String address;
    private String bloodgroup;
    private String vaccination;
    private String illness;

    public UserDetails() {

    }
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserContactNumber() {
        return phonenumber;
    }

    public void setUserContactNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserAddress() {
        return address;
    }

    public void setUserAddress(String address) {
        this.address = address;
    }
    public String getUserBloodGruop() {
       return bloodgroup;
    }



    public void setUserBloodGruop(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
    public String getUserVaccinationStatus() {
        return vaccination;
    }

    public void setUserVaccinationStatus(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getUserIllness() {
        return illness;
    }

    public void setUserIllness(String illness) {
        this.illness = illness;
    }
}

