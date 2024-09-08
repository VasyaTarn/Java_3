package com.company.models;

import com.company.printable.HospitalPrintable;

public class Hospital extends Building {
    private String name;
    private int nPatients;

    private HospitalPrintable printable;

    public Hospital(String address, String name, int nPatients, HospitalPrintable printable)
    {
        super(address);
        this.name = name;
        this.nPatients = nPatients;
        this.printable = printable;
    }

    @Override
    public void printInfo()
    {
        printable.print(this);
    }

    public String getName()
    {
        return name;
    }

    public int getNPatients()
    {
        return nPatients;
    }
}
