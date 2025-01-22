package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.casestudy.dao.*;
import com.casestudy.*;
import com.casestudy.submenu.*;

public class ServiceSubmenu {
	
	private static void newService(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		HashSet<Services> serviceSet = ServiceDao.readService();
		System.out.println("Enter ServiceId and Service Description : ");
		serviceSet.add(new Services(sc.nextInt(), sc.next()));
		ServiceDao.writeService(serviceSet);
		
	}
	
	private static double existingService(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {

		HashSet<Services> serviceSet = ServiceDao.readService();
		for(Services ele : serviceSet) {
			
			System.out.println(ele);
			
		}
		
		System.out.println("Enter ServiceID to proceed: ");
		int id = sc.nextInt();
		for(Services ele : serviceSet) {
			
			if(ele.getServiceId() == id) {
				
				System.out.println("Enter Service Charges: ");
				return sc.nextDouble();
				
			}
			
		}
		System.out.println("Enter valid ServiceID!!!");
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
	
	private static double repairing(Scanner sc,Bill bill) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		LinkedList<Parts> parts = PartsDao.readParts();
		
		for(Parts ele: parts) 
			System.out.println(ele);
			
		System.out.println("Enter partID repaired/replaced part: ");
		String id = sc.next();
		
		for(Parts ele: parts) { 
			if(ele.getPartId() == id) {
				
				System.out.println("Enter Labour Charge: ");
				double labourCharge = sc.nextDouble();
				
				bill.setAmount(bill.getAmount()+ labourCharge + ele.getPrize());
				return bill.getAmount();
				
			}
		}
		
		System.out.println("Enter valid PartId!!!");
		return 0;
		
	}
	
	private static double oilChange(Scanner sc, Bill bill) {
			
		System.out.println("Enter Which Oil is used: ");
		String Oil = sc.next();
		System.out.println("Enter price for the oil: ");
		double oilPrice = sc.nextDouble();
		
		bill.setAmount(bill.getAmount()+ oilPrice);
		
		return oilPrice;
		
	}
	
	private static int menu(Scanner sc) {
		
		System.out.println("########Process Request#######");
		System.out.println("1.New Service");
		System.out.println("2.Existing Service");
		System.out.println("3.Maintainance");
		System.out.println("4.Repairing");
		System.out.println("5.Oil Change");
		System.out.println("6.Generate Bill");
		System.out.println("##############################");
		
		System.out.println("Enter choice: ");
		
		return sc.nextInt();
		
	}
	
	private static int servicemenu(Scanner sc) {
		System.out.println("**********************");
		System.out.println("1. oil change");
		System.out.println("2. repair ");
		//System.out.println("**********************");
		//System.out.println("**********************");
		//System.out.println("**********************");
		System.out.println("**********************");
		return sc.nextInt();
	}
	
	
	public static Bill processSubMenu(Bill bill, Customer c, Vehicle v, Date date) throws FileNotFoundException, ClassNotFoundException, IOException {
			
		int choice;
		double serviceCost = 0, maintainanceCost = 0, repairCost = 0, oilChangeCost = 0;
		Scanner sc = new Scanner(System.in);
		HashSet<Services> serviceSet = ServiceDao.readService();
		while(true) {
			
			choice = menu(sc);
			
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
				while(true) {
					int ch=servicemenu(sc);
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
				}
				
				
				case 5:
				Bill.printBill(bill, c, v, serviceCost, maintainanceCost, repairCost, oilChangeCost, date);
				return bill;
			default:
				System.out.println("Enter valid choice!!!");
				break;
			}
			
		}
		
	}

	
}