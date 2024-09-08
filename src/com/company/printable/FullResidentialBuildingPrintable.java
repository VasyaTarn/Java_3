package com.company.printable;

import com.company.models.ResidentialBuilding;

public class FullResidentialBuildingPrintable implements ResidentialBuildingPrintable {
    @Override
    public void print(ResidentialBuilding residentialBuilding)
    {
        System.out.println("Residential building address: " + residentialBuilding.getAddress());
        System.out.println("Residential building number of residents: " + residentialBuilding.getNResidents());
    }
}
