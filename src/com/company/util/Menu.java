package com.company.util;

import com.company.enums.Department;
import com.company.models.*;

import java.util.Scanner;

public class Menu {
    private Street street;
    private Scanner scanner;

    public Menu()
    {
        this.street = Factory.createStreet();
        this.scanner = new Scanner(System.in);
    }

    public Menu(Street street)
    {
        this.street = street;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu()
    {
        while (true)
        {
            System.out.println("=".repeat(10) + " Menu " + "=".repeat(10));
            System.out.println("1. Add building");
            System.out.println("2. Remove building");
            System.out.println("3. Show information about all buildings");
            System.out.println("4. Find shops with a department");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    addBuilding();
                    break;
                case 2:
                    removeBuilding();
                    break;
                case 3:
                    street.printStreet();
                    break;
                case 4:
                    searchShop();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addBuilding()
    {
        System.out.println("What building do you want to add?");
        System.out.println("1. Residential building");
        System.out.println("2. Shop");
        System.out.println("3. School");
        System.out.println("4. Hospital");
        System.out.print("Select type: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1:
                street.addBuilding(Factory.createResidentialBuilding(street));
                break;
            case 2:
                street.addBuilding(Factory.createShop(street));
            case 3:
                street.addBuilding(Factory.createSchool(street));
                break;
            case 4:
                street.addBuilding(Factory.createHospital(street));
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    private void removeBuilding()
    {
        System.out.println("Enter the address of the building to be deleted: ");
        String address = scanner.nextLine();

        street.removeBuilding(address);
    }

    private void searchShop()
    {
        int range;
        do{
            System.out.println("Enter search range: ");
            range = scanner.nextInt();
        }while (range < 0 || range > street.getBuildings().size());

        scanner.nextLine();

        System.out.println("Enter department name to search: ");
        String department = scanner.nextLine();

        Department searchDepartment = null;

        for (Department element : Department.values()) {
            if (element.name().equals(department)) {
                searchDepartment = element;
            }
        }

        if(searchDepartment != null)
        {
            street.searchShop(range, searchDepartment);
        }
        else
        {
            System.out.println("No such department found");
        }
    }
}
