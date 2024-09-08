package com.company.printable;

import com.company.models.ResidentialBuilding;

public class BriefResidentialBuildingPrintable implements ResidentialBuildingPrintable {
    @Override
    public void print(ResidentialBuilding residentialBuilding)
    {
        System.out.println("Residential building address: " + residentialBuilding.getAddress());
    }
}
