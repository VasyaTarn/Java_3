package com.company.printable;

import com.company.models.School;

public class BriefSchoolPrintable implements SchoolPrintable {
    @Override
    public void print(School school)
    {
        System.out.println("School address: " + school.getAddress());
    }
}
