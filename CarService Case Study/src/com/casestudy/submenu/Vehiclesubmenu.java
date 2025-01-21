package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.casestudy.Customer;
import com.casestudy.Vehicle;
import com.casestudy.dao.CustomerDao;

public class Vehiclesubmenu {
	
	
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Vehicle");
		System.out.println("2. Show all Vehicle");
		System.out.println("3. show Customer Vehicle ");
		System.out.println("4. Edit Vehicle");
		System.out.println("4. Delete Vehicle");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	
static HashSet<Vehicle> VehicleSet =new HashSet<>();
	
	public static void  VSmenu(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {

		int CSchoice;

		while((CSchoice=menu(sc))!=0) {
			switch(CSchoice) {
			
			case 1: 
			System.out.println("Enter the name,phone number,address of the customer :");
			VehicleSet.add(new Vehicle(sc.next(),sc.next(),sc.next()));
			VehicleDao.writeVehicle(VehicleSet);
					
				break;
				
			case 2:
				VehicleSet=VehicleDao.readvehicle();
				if (VehicleSet.isEmpty()) {
                System.out.println("No vehicle found.");
            } else {
            	for (Vehicle vehicle : VehicleSet) {
                    System.out.println(vehicle);
			}
            }
				break;
				
				
				
				
				
			case 3:
				System.out.println("Enter the registered phone number of the customer :");
				String phone =sc.next();
				System.out.println("select what you want to change :");
				
				for (Vehicle vehicle : VehicleSet) {
					if(phone.equals(customer.getPh_no())) {
						int Editchoice;
						while((Editchoice=EditCustomer(sc))!=0) {
							switch(Editchoice) {
							case 1:
								System.out.println("Enter the new name :");
								String name=sc.next();
								customer.setName(name);
								break;
							case 2:
								System.out.println("Enter the new address :");
								String address=sc.next();
								customer.setC_address(address);
								break;
							}
						}
					}else {
						System.out.println("NO SUCH ENTRY IS PRESENT...");
					}
				}
				CustomerDao.writeCustomer(VehicleSet);
				break;

	
}
