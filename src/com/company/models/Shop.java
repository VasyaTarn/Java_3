package com.company.models;

import com.company.enums.Department;
import com.company.printable.ShopPrintable;
import com.company.util.Factory;
import com.company.enums.ShopType;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Building {
    private String name;
    private ShopType shopType;
    private List<Department> departments;

    private ShopPrintable printable;

    public Shop(String address, String name, ShopType shopType, ShopPrintable printable)
    {
        super(address);
        this.name = name;
        this.shopType = shopType;
        this.departments = Factory.generateDepartmentList(shopType);
        this.printable = printable;
    }

    public Shop(String address, String name, ShopType shopType, List<Department> departments, ShopPrintable printable)
    {
        super(address);
        this.name = name;
        this.shopType = shopType;
        this.departments = new ArrayList<>();
        this.departments.addAll(departments);
        this.printable = printable;
    }

    @Override
    public void printInfo()
    {
        printable.print(this);
    }

    public String getName()
    {
        return name;
    }

    public ShopType getShopType()
    {
        return shopType;
    }

    public List<Department> getDepartments()
    {
        return departments;
    }
}
