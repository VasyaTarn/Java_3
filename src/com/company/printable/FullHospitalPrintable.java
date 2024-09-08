package com.company.printable;

import com.company.models.Hospital;

public class FullHospitalPrintable implements HospitalPrintable {
    @Override
    public void print(Hospital hospital)
    {
        System.out.println("Hospital address: " + hospital.getAddress());
        System.out.println("Hospital name: " + hospital.getName());
        System.out.println("Hospital number of patients: " + hospital.getNPatients());
    }
}
