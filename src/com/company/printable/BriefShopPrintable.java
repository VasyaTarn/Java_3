package com.company.printable;

import com.company.enums.Department;
import com.company.models.Shop;

public class BriefShopPrintable implements ShopPrintable {
    @Override
    public void print(Shop shop)
    {
        System.out.println("Shop address: " + shop.getAddress());
    }
}
