package com.company.enums;

public enum ShopType {
    Supermarket(10),
    Minimarket(5),
    Deli(3),
    Pharmacy(4);

    private final int departments;

    ShopType(int departments) {
        this.departments = departments;
    }

    public int getDepartments() {
        return departments;
    }
}
