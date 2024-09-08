package com.company.printable;

import com.company.enums.Department;
import com.company.models.School;
import com.company.models.Shop;

public class FullShopPrintable implements ShopPrintable {
    @Override
    public void print(Shop shop)
    {
        System.out.println("Shop address: " + shop.getAddress());
        System.out.println("Shop name: " + shop.getName());
        System.out.println("Shop type: " + shop.getShopType());
        System.out.print("Shop departments: ");
        for (Department department : shop.getDepartments())
        {
            System.out.print(department + " | ");
        }

        System.out.println();
    }
}
