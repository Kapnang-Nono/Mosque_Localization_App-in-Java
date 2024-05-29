package com.example.mosquelocalizationapplication;

import android.util.Log;

public class Mosque {
    public int id;
    public String name;
    public String address;
    public String prayerTime;
    public double longitude;
    public double latitude;
    public String city;

    public Mosque(String name, String address, String prayerTime, double longitude, double latitude){
        this.name = name;
        this.address = address;
        this.prayerTime = prayerTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddress() {
        Log.d("address", address);
        return address;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPrayerTime() {
        return prayerTime;
    }

    public String getCity() {
        return city;
    }
}
