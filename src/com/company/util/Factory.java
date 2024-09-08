package com.company.util;

import com.company.enums.AccreditationLevel;
import com.company.enums.Department;
import com.company.enums.ShopType;
import com.company.models.*;
import com.company.printable.*;

import java.util.*;

public class Factory {
    private static final Random random = new Random();

    private static final String[] hospitalNames = {
            "Central City Hospital",
            "Saint Mary's Medical Center",
            "Riverside General Hospital",
            "Green Valley Clinic",
            "Sunnybrook Medical Center",
            "Mercy Health Hospital",
            "Oakwood Medical Institute",
            "Northside Regional Hospital",
            "Pine Hill Community Health",
            "Lakeview General Hospital",
            "Hopewell Medical Center",
            "Eastside Medical Clinic",
            "Westbrook Health Center",
            "Springfield General Hospital",
            "Unity Health Care",
            "Parkway Hospital",
            "New Horizon Medical Center",
            "Riverbend Hospital",
            "Grandview Health Clinic",
            "Maplewood Medical Center"
    };

    private static final String[] shopNames = {
            "Walmart",
            "Costco",
            "Target",
            "Aldi",
            "Kroger",
            "Tesco",
            "Carrefour",
            "Lidl",
            "Whole Foods",
            "Safeway",
            "Trader Joe's",
            "IKEA",
            "Best Buy",
            "7-Eleven",
            "Home Depot",
            "Marks & Spencer",
            "Sainsbury's",
            "Macy's",
            "Dollar General",
            "Asda"
    };

    private static final String[] streetNames = {
            "Main Street",
            "Oak Avenue",
            "Maple Street",
            "Cedar Lane",
            "Pine Street",
            "Elm Road",
            "Highland Avenue",
            "River Road",
            "Park Street",
            "Hilltop Drive",
            "Sunset Boulevard",
            "Broadway",
            "Chestnut Street",
            "Willow Lane",
            "Birch Avenue",
            "Hawthorn Road",
            "Lakeside Drive",
            "Forest Avenue",
            "Meadow Lane",
            "Walnut Street"
    };

    public static Street createStreet()
    {
        Street street = new Street();

        street.setName(randomFromArray(streetNames));

        int numberOfBuildings = random.nextInt(20) + 5;

        for (int i = 0; i < numberOfBuildings; i++) {
            Building building;

            int randomType = random.nextInt(100);
            if (randomType < 60) {
                building = createResidentialBuilding(street);
            } else if (randomType < 80) {
                building = createShop(street);
            } else if (randomType < 90) {
                building = createHospital(street);
            } else {
                building = createSchool(street);
            }

            street.addBuilding(building);
        }

        return street;
    }

    public static Hospital createHospital(Street street)
    {
        HospitalPrintable printable = new FullHospitalPrintable();
        return new Hospital(generateHouseNumber(street), randomFromArray(hospitalNames), random.nextInt(10000) + 1, printable);
    }

    public static ResidentialBuilding createResidentialBuilding(Street street)
    {
        ResidentialBuildingPrintable printable = new FullResidentialBuildingPrintable();
        return new ResidentialBuilding(generateHouseNumber(street), random.nextInt(500) + 1, printable);
    }

    public static School createSchool(Street street)
    {
        SchoolPrintable printable = new FullSchoolPrintable();
        return new School(generateHouseNumber(street), generateAccreditationLevel(), printable);
    }

    public static Shop createShop(Street street)
    {
        ShopPrintable printable = new FullShopPrintable();
        return new Shop(generateHouseNumber(street), randomFromArray(shopNames), generateShopType(), printable);
    }

    public static AccreditationLevel generateAccreditationLevel()
    {
        return AccreditationLevel.values()[random.nextInt(AccreditationLevel.values().length)];
    }

    public static ShopType generateShopType()
    {
        return ShopType.values()[random.nextInt(ShopType.values().length)];
    }

    public static String generateHouseNumber(Street street) {
        //String number = Integer.toString(random.nextInt(200) + 1);
        String number = Integer.toString(100 + random.nextInt(5));

        List<String> temp = new ArrayList<String>();
        for (Map.Entry<String, Building> entry : street.getBuildings().entrySet())
        {
            if(number.equals(entry.getKey()) || number.equals(entry.getKey().substring(0, entry.getKey().length() - 1)))
            {
                temp.add(entry.getKey());
            }
        }

        if(!temp.isEmpty())
        {
            String lastElement = temp.get(temp.size() - 1);

            if(Character.isLetter(lastElement.charAt(lastElement.length() - 1)))
                return lastElement.substring(0, lastElement.length() - 1) + (char)(lastElement.substring(lastElement.length() - 1).charAt(0) + 1);

            return lastElement + "A";
        }

        return number;
    }

    public static List<Department> generateDepartmentList(ShopType shopType)
    {
        List<Department> temp = new ArrayList<>();
        for(int i = 0; i < shopType.getDepartments(); i++)
        {
            temp.add(Department.values()[random.nextInt(Department.values().length)]);
        }

        return temp;
    }

    private static String randomFromArray(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
