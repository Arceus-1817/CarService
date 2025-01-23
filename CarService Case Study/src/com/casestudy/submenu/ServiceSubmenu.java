package com.casestudy.submenu;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

import com.casestudy.dao.*;
import com.casestudy.*;

public class ServiceSubmenu {

	private static void newService(Scanner sc) throws IOException, ClassNotFoundException {
	    HashSet<Services> serviceSet = ServiceDao.readService();
	    if (serviceSet == null) {
	        serviceSet = new HashSet<>(); 
	    }

	    System.out.println("Enter ServiceId (numeric) and Service Description (text):");
	    if (sc.hasNextDouble()) {
	        Double serviceId = sc.nextDouble();
	        sc.nextLine();  
	        String description = sc.nextLine(); 
	        serviceSet.add(new Services(serviceId, description));
	        ServiceDao.writeService(serviceSet);
	        System.out.println("New service added successfully!");
	    } else {
	        System.out.println("Invalid ServiceId. Please enter a numeric value.");
	        sc.nextLine(); 
	    }
	}


	private static double existingService(Scanner sc) throws IOException, ClassNotFoundException {
	    HashSet<Services> serviceSet = ServiceDao.readService();
	    if (serviceSet == null || serviceSet.isEmpty()) {
	        System.out.println("No services available.");
	        return 0;
	    }

	    System.out.println("Available services:");
	    for (Services ele : serviceSet) {
	        System.out.println(ele);
	    }

	    System.out.println("Enter ServiceId to proceed:");
	    if (sc.hasNextDouble()) {
	        Double id = sc.nextDouble();
	        for (Services ele : serviceSet) {
	            if (Objects.equals(ele.getServiceId(), id)) {
	                System.out.println("Enter Service Charges:");
	                return sc.nextDouble();
	            }
	        }
	        System.out.println("No service found with the provided ServiceId.");
	    } else {
	        System.out.println("Invalid ServiceId. Please enter a numeric value.");
	        sc.nextLine(); 
	    }
	    return 0;
	}


    private static double maintainance(Scanner sc, Bill bill) {
        System.out.println("Enter Maintainance Cost: ");
        double maintainance = sc.nextDouble();

        System.out.println("Enter Labour charges: ");
        double labourCharge = sc.nextDouble();

        bill.setAmount(bill.getAmount() + maintainance + labourCharge);

        return maintainance + labourCharge;
    }

    private static double repairing(Scanner sc, Bill bill) throws IOException, ClassNotFoundException {
        LinkedList<Parts> parts = PartsDao.readParts();

        for (Parts ele : parts) {
            System.out.println(ele);
        }

        System.out.println("Enter partID repaired/replaced part: ");
        String id = sc.next();

        for (Parts ele : parts) {
            if (ele.getPartId().equals(id)) {
                System.out.println("Enter Labour Charge: ");
                double labourCharge = sc.nextDouble();

                bill.setAmount(bill.getAmount() + labourCharge + ele.getPrice());
                return bill.getAmount();
            }
        }

        System.out.println("Enter valid PartId!!!");
        return 0;
    }

    private static double oilChange(Scanner sc, Bill bill) {
        System.out.println("Enter Which Oil is used: ");
        String oil = sc.next();
        System.out.println("Enter price for the oil: ");
        double oilPrice = sc.nextDouble();

        bill.setAmount(bill.getAmount() + oilPrice);

        return oilPrice;
    }

    private static int servicemenu(Scanner sc) {
    	System.out.println("**********************");
    	System.out.println("0. exit");
    	System.out.println("1. oil change");
    	System.out.println("2. repair ");
    	System.out.println("**********************");
    	return sc.nextInt();
    }
    private static int menu(Scanner sc) {
        int choice = -1;
        while (choice < 0 || choice > 6) { 
            System.out.println("******************************");
            System.out.println("1. New Service");
            System.out.println("2. Existing Service");
            System.out.println("3. Maintainance");
            System.out.println("4. Service menu");
            System.out.println("5. Generate Bill");
            System.out.println("******************************");

            System.out.print("Enter choice: ");
            
            if (sc.hasNextInt()) {
                choice = sc.nextInt(); 
                sc.nextLine(); 
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();  
            }
        }
        return choice;
    }

    public static Bill processSubMenu() {
        double serviceCost = 0, maintainanceCost = 0, repairCost = 0, oilChangeCost = 0;
        Scanner sc = new Scanner(System.in);
        Bill bill = new Bill();

        try {
            System.out.println("Enter Customer ID:");
            Customer c = CustomerDao.readspecific(sc.next());

            System.out.println("Enter Vehicle ID:");
            Vehicle v = VehicleDao.readspecific(sc.next());

            bill.setCustomer(c);
            bill.setVehicle(v);

            while (true) {
                int choice = menu(sc);

                switch (choice) {
                    case 1:
                        newService(sc);
                        break;
                    case 2:
                        serviceCost = existingService(sc);
                        break;
                    case 3:
                        maintainanceCost = maintainance(sc, bill);
                        break;
                    case 4:
                        while (true) {
                            int ch = servicemenu(sc);
                            switch (ch) {
                                case 1:
                                    repairCost = repairing(sc, bill);
                                    break;
                                case 2:
                                    oilChangeCost = oilChange(sc, bill);
                                    break;
                                default:
                                    break;
                            }
                            if (ch != 1 && ch != 2) break;
                        }
                        break;
                    case 5:
                    	if (bill.getCustomer() == null || bill.getVehicle() == null) {
                            System.out.println("Error: Missing customer or vehicle data.");
                            return null;
                        }
                        Bill.printBill(bill, c, v, serviceCost, maintainanceCost, repairCost, oilChangeCost);
                        return bill; 
                    default:
                        System.out.println("Enter valid choice!!!");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return bill;
    }
}
