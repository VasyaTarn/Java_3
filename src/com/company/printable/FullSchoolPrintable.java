package com.company.printable;

import com.company.models.ResidentialBuilding;
import com.company.models.School;

public class FullSchoolPrintable implements SchoolPrintable {
    @Override
    public void print(School school)
    {
        System.out.println("School address: " + school.getAddress());
        System.out.println("School accreditation Level: " + school.getAccreditationLevel());
        System.out.println("School number of students: " + school.getNStudents());
    }
}
