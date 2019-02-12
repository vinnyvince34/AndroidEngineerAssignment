package com.example.miniproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
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

    protected Users(Parcel in) {
        sID = in.readString();
        sAddress = in.readString();
        sPhone = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sID);
        dest.writeString(sAddress);
        dest.writeString(sPhone);
    }
}
