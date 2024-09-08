package com.company.models;

import com.company.printable.ResidentialBuildingPrintable;

public class ResidentialBuilding extends Building {
    private int nResidents;

    private ResidentialBuildingPrintable printable;

    public ResidentialBuilding(String address, int nResidents, ResidentialBuildingPrintable printable)
    {
        super(address);
        this.nResidents = nResidents;
        this.printable = printable;
    }

    @Override
    public void printInfo()
    {
        printable.print(this);
    }

    public int getNResidents()
    {
        return nResidents;
    }
}
