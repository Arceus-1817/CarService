//delete




package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.casestudy.Customer;
import com.casestudy.Vehicle;
import com.casestudy.dao.CustomerDao;
import com.casestudy.dao.VehicleDao;
import com.casestudy.submenu.*;

public class Vehiclesubmenu {
	
	
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Vehicle");
		System.out.println("2. Show all Vehicle");
		System.out.println("3. show Customer Vehicle ");
		System.out.println("4. Edit Vehicle");
		System.out.println("5. Delete Vehicle");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	 static HashSet<Vehicle> VehicleSet =new HashSet<Vehicle>();
	 static HashMap<Customer, Vehicle> vehicleMap = new HashMap<>();
	  
	   
	        
	public static void  VSmenu(Scanner sc)throws FileNotFoundException, ClassNotFoundException, IOException  {

		int VSchoice;
		
		while((VSchoice=menu(sc))!=0) {
			switch(VSchoice) {
			
			case 1: 

			System.out.println("Enter the reg number,company,model of the car :");
			String regnum =sc.next();
			String company =sc.next();
			String model =sc.next();
			Vehicle NewVehicle=new Vehicle(regnum, company, model);
			VehicleSet.add(NewVehicle);
			
			
			 System.out.println("Enter the customer phone number");
			 String phone =sc.next();
			 
			 Customer NewCustomer = CustomerDao.readspecific(phone);

			 if (NewCustomer != null) {
			        vehicleMap.put(NewCustomer, NewVehicle);
			        System.out.println("Vehicle added for customer: " + NewCustomer.getPh_no());
			    } else {
			        System.out.println("Customer not found with phone number: " + phone);
			    }
			 
			VehicleDao.write(vehicleMap);
			VehicleDao.writeVehicle(VehicleSet);
			
			 
			//VehicleDao.writeVehicle(VehicleSet);
					
				break;
				
			case 2:
				HashSet<Vehicle> vehicle = VehicleDao.readVehicle();
	
			VehicleSet=VehicleDao.readVehicle();
				//VehicleSet=VehicleDao.readVehicle();
				if (VehicleSet.isEmpty()) {
                System.out.println("No vehicle found.");
            } else {
            	for (Vehicle ele : vehicle) {
                    System.out.println(ele);
			}
            }
				break;
				
				
			case 3:
				
				HashSet<Customer> customer = CustomerDao.readCustomer();
				System.out.println("Enter the Customer phone number :");
				String ph=sc.next();
				 for(Customer ele : customer) {

					 if(ele.getPh_no().equals(ph)) {
				           Vehicle vehicle1 = Vehiclesubmenu.vehicleMap.get(ele);

						 System.out.println(ph+ ":"+vehicle1);
					 }
				 }
				 break;
				
			case 4:
				System.out.println("Enter the registered number of the car :");
				String regnumber =sc.next();
				System.out.println("select what you want to change :");
				HashSet<Vehicle> vehicle1 = VehicleDao.readVehicle();
				for (Vehicle ele : vehicle1) {
					if(regnumber.equals(ele.getReg_no())) {
						
								System.out.println("Enter the new number :");
								String name=sc.next();
								ele.setReg_no(name);

						}
					else {
						System.out.println("NO SUCH ENTRY IS PRESENT...");
					}
				}
				VehicleDao.write(vehicleMap);
				VehicleDao.writeVehicle(VehicleSet);
				break;
				
				
			case 5:
				HashSet<Vehicle> vehicle11 = VehicleDao.readVehicle();

				System.out.println("Enter the registered number of the car you want to delete :");
				String Cdelete =sc.next();
				for (Vehicle  ele: vehicle11) {
					if(Cdelete.equals(ele.getReg_no())) {
						vehicle11.remove(ele);
						System.out.println("The record is deleted.....");
					}
					VehicleDao.writeVehicle(VehicleSet);
				
							
	
			}
		}
	}
	}	
}

