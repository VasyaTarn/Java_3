package com.company.models;

public abstract class Building {
    protected String address;

    protected Building(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public abstract void printInfo();
}
