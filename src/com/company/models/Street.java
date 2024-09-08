package com.company.models;

import com.company.enums.Department;

import java.util.*;

public class Street {
    private String name;
    private Map<String, Building> buildings = new TreeMap<>();

    public void printStreet()
    {
        System.out.println("-".repeat(20) + name + "-".repeat(20));

        for (Map.Entry<String, Building> entry : buildings.entrySet()) {
            entry.getValue().printInfo();
            System.out.println();
        }
    }

    public void addBuilding(Building building)
    {
        boolean isDuplicate = false;

        for (Map.Entry<String, Building> entry : buildings.entrySet()) {
            if (building.getAddress().equals(entry.getKey())) {
                isDuplicate = true;
                break;
            }
        }

        if(!isDuplicate)
            buildings.put(building.getAddress(), building);
        else
            System.out.println("There is already such a building on the street");
    }

    public void removeBuilding(String address)
    {
        boolean isFound = false;

        for (Map.Entry<String, Building> entry : buildings.entrySet()) {
            if (address.equals(entry.getKey())) {
                isFound = true;
            }
        }

        if(isFound)
            buildings.remove(address);
        else
            System.out.println("There is no such a building on the street");
    }

    public void searchShop(int searchRange, Department department)
    {
        Random random = new Random();

        List<Building> allBuildings = new ArrayList<>();
        List<Building> resistantBuildings = new ArrayList<>();
        List<Building> shops = new ArrayList<>();

        for (Map.Entry<String, Building> entry : buildings.entrySet()) {
            allBuildings.add(entry.getValue());
            if(entry.getValue() instanceof ResidentialBuilding)
            {
                resistantBuildings.add(entry.getValue());
            }
        }

        if(!resistantBuildings.isEmpty())
        {
            Building randomResistantBuilding = resistantBuildings.get(random.nextInt(resistantBuildings.size()));
            int indexRandomResistantBuilding = allBuildings.indexOf(randomResistantBuilding);

            if (indexRandomResistantBuilding - searchRange < 0 && indexRandomResistantBuilding + searchRange > allBuildings.size() - 1)
            {
                for (int i = 0; i < allBuildings.size(); i++)
                {
                    if (allBuildings.get(i) instanceof Shop)
                    {
                        if (((Shop) allBuildings.get(i)).getDepartments().contains(department))
                        {
                            shops.add(allBuildings.get(i));
                        }
                    }
                }
            }
            else if (indexRandomResistantBuilding - searchRange < 0)
            {
                for (int i = 0; i <= indexRandomResistantBuilding + searchRange; i++) {
                    if (allBuildings.get(i) instanceof Shop) {
                        if (((Shop) allBuildings.get(i)).getDepartments().contains(department)) {
                            shops.add(allBuildings.get(i));
                        }
                    }
                }
            }
            else if (indexRandomResistantBuilding + searchRange > allBuildings.size())
            {
                for (int i = indexRandomResistantBuilding - searchRange; i < allBuildings.size(); i++)
                {
                    if (allBuildings.get(i) instanceof Shop)
                    {
                        if (((Shop) allBuildings.get(i)).getDepartments().contains(department))
                        {
                            shops.add(allBuildings.get(i));
                        }
                    }
                }
            }
            else
            {
                for (int i = indexRandomResistantBuilding - searchRange; i < indexRandomResistantBuilding + searchRange; i++)
                {
                    if (allBuildings.get(i) instanceof Shop)
                    {
                        if (((Shop) allBuildings.get(i)).getDepartments().contains(department))
                        {
                            shops.add(allBuildings.get(i));
                        }
                    }
                }
            }

            if (!shops.isEmpty()) {
                System.out.println("-".repeat(20) + "Nearest shops: " + "-".repeat(20));
                System.out.println("Resistant building address: " + randomResistantBuilding.getAddress());
                System.out.println();
                for (Building building : shops) {
                    building.printInfo();
                }
            } else {
                System.out.println("There is not a single shop nearby");
            }
        }
        else
        {
            System.out.println("There are no residential buildings on this street");
        }
    }

    public Map<String, Building> getBuildings() {
        return buildings;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
