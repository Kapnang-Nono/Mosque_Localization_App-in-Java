package com.example.mosquelocalizationapplication;

public class Mosque {
    public int id;
    public String name;
    public String address;
    public String prayerTime;

    public Mosque(int id, String name, String address, String prayerTime){
        this.id = id;
        this.name = name;
        this.address = address;
        this.prayerTime = prayerTime;
    }
}
