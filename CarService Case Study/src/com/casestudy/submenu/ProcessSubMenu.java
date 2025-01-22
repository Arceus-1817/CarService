package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.casestudy.Bill;
import com.casestudy.Customer;
import com.casestudy.Parts;
import com.casestudy.Services;
import com.casestudy.Vehicle;
import com.casestudy.dao.PartsDao;
import com.casestudy.dao.ServiceDao;

public class ProcessSubMenu {

    private static Bill bill = new Bill();
    private static Customer customer;
    private static Vehicle vehicle;
    private static double serviceCost;

    public static int menu(Scanner sc) {
        System.out.println("********************************************");
        System.out.println("0. Exit");
        System.out.println("1. Add New Service");
        System.out.println("2. Existing Service");
        System.out.println("3. Maintenance");
        System.out.println("4. Repairing");
        System.out.println("5. Oil Changing");
        System.out.println("6. Print Bill");
        System.out.println("********************************************");
        return sc.nextInt();
    }

    public static int processMenu(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {
        int choice;
        while ((choice = menu(sc)) != 0) {
            switch (choice) {
                case 1:
                    addNewService(sc);
                    break;
                case 2:
                    existingService(sc);
                    break;
                case 3:
                	serviceCost +=Services();
                	break;
                case 4:
                    serviceCost += repairing(sc);
                    break;
                case 5:
                    serviceCost += oilChange(sc);
                    break;
                case 6:
                    printBill();
                    break;
                default:
                    System.out.println("Enter a valid choice... :(");
            }
        }
        return choice;
    }

    private static void addNewService(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {
        HashSet<Services> serviceSet = ServiceDao.readService();
        System.out.println("Enter the new service name:");
        String name = sc.next();
        System.out.println("Enter the service cost:");
        double cost = sc.nextDouble();
        Services service = new Services(name, cost);
        serviceSet.add(service);
        ServiceDao.writeService(serviceSet);
        System.out.println("Service added successfully!");
    }

    private static void existingService(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {
        HashSet<Services> serviceSet = ServiceDao.readService();
        if (serviceSet.isEmpty()) {
            System.out.println("No services found.");
            return;
        }

        for (Services service : serviceSet) {
            System.out.println(service);
        }

        System.out.println("Enter the service name to view details:");
        String name = sc.next();
        for (Services service : serviceSet) {
            if (service.getS_name().equals(name)) {
                System.out.println("Service Details: " + service);
                return;
            }
        }
        System.out.println("Service not found.");
    }

    private static double maintenance(Scanner sc) {
        System.out.println("Enter the maintenance cost:");
        double maintenanceCost = sc.nextDouble();
        System.out.println("Enter labor charges:");
        double laborCharges = sc.nextDouble();
        double totalCost = maintenanceCost + laborCharges;
        bill.setAmount(bill.getAmount() + totalCost);
        return totalCost;
    }

    private static double repairing(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {
        System.out.println("Enter the part ID to repair:");
        LinkedList<Parts> parts = PartsDao.readParts();
        if (parts.isEmpty()) {
            System.out.println("No parts available.");
            return 0;
        }

        for (Parts part : parts) {
            System.out.println(part);
        }

        String partId = sc.next();
        for (Parts part : parts) {
            if (part.getPartId().equals(partId)) {
                System.out.println("Enter labor charges:");
                double laborCharges = sc.nextDouble();
                double totalCost = laborCharges + part.getPrice();
                bill.setAmount(bill.getAmount() + totalCost);
                return totalCost;
            }
        }
        System.out.println("Part not found.");
        return 0;
    }

    private static double oilChange(Scanner sc) {
        System.out.println("Enter the oil type:");
        String oilType = sc.next();
        System.out.println("Enter the price of the oil:");
        double price = sc.nextDouble();
        bill.setAmount(bill.getAmount() + price);
        return price;
    }

    private static void printBill() {
        System.out.println("################# Final Bill Summary ##################");
        System.out.println("\nCustomer: " + customer.getName() + "  Mobile: " + customer.getPh_no());
        System.out.println("\nVehicle: " + vehicle.getCompany() + " " + vehicle.getModel() + "  Registration No: " + vehicle.getReg_no());
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nDescription             Amount");
        System.out.println("\nService Cost:           " + serviceCost + " rs");
        System.out.println("\nTotal:                  " + bill.getAmount() + " rs");
        System.out.println("\nGST:                    " + Bill.gst + "%");
        bill.setAmount(bill.getAmount() + ((bill.getAmount() * Bill.gst) / 100));
        System.out.println("\nFinal Total (With GST): " + bill.getAmount() + " rs");
        System.out.println("\n########## Thank You For Taking Our Service! ###########\n");
    }
}
