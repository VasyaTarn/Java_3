package com.company.enums;

public enum AccreditationLevel {
    Secondary(300),
    Gymnasium(800),
    Lyceum(1200);

    private final int nStudents;

    AccreditationLevel(int nStudents)
    {
        this.nStudents = nStudents;
    }

    public int getNStudents()
    {
        return nStudents;
    }
}
