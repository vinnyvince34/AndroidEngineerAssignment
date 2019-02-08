package com.example.miniproject;

public class Users {
    private String sID = "";
    private String sAddress = "";
    private String sPhone = "";

    public Users() {
        sID = "";
        sAddress = "";
        sPhone = "";
    }

    public Users(String x, String y, String z) {
        sID = x;
        sAddress = y;
        sPhone = z;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    @Override
    public String toString() {
        return "ID: " + sID + '\n' +
                "Address: " + sAddress + '\n' +
                "Phone: " + sPhone + '\n';
    }
}
