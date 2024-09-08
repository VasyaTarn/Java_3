package com.company.printable;

import com.company.models.Hospital;

public class BriefHospitalPrintable implements HospitalPrintable {
    @Override
    public void print(Hospital hospital)
    {
        System.out.println("Hospital address: " + hospital.getAddress());
    }
}
