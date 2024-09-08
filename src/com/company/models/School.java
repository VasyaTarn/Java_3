package com.company.models;

import com.company.enums.AccreditationLevel;
import com.company.printable.SchoolPrintable;

import java.util.Random;

public class School extends Building {
    private AccreditationLevel accreditationLevel;
    private int nStudents;

    private SchoolPrintable printable;

    private final int generationRange = 100;

    public School(String address, AccreditationLevel accreditationLevel, SchoolPrintable printable)
    {
        super(address);
        this.accreditationLevel = accreditationLevel;
        this.printable = printable;

        Random random = new Random();

        if(accreditationLevel.getNStudents() - generationRange > 0)
        {
            this.nStudents = random.nextInt((accreditationLevel.getNStudents() + generationRange) - (accreditationLevel.getNStudents() - generationRange) + 1) + (accreditationLevel.getNStudents() - generationRange);
        }
        else
        {
            this.nStudents = accreditationLevel.getNStudents();
        }

    }

    public School(String address, AccreditationLevel accreditationLevel, int nStudents, SchoolPrintable printable)
    {
        super(address);
        this.accreditationLevel = accreditationLevel;
        this.nStudents = nStudents;
        this.printable = printable;
    }

    @Override
    public void printInfo()
    {
        printable.print(this);
    }

    public AccreditationLevel getAccreditationLevel()
    {
        return accreditationLevel;
    }

    public int getNStudents()
    {
        return nStudents;
    }
}
