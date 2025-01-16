<<<<<<< HEAD
//delete
=======
//05  03  file
>>>>>>> main



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
<<<<<<< HEAD
			Vehicle NewVehicle=new Vehicle(regnum, company, model);
			VehicleSet.add(NewVehicle);
=======
			VehicleSet.add(new Vehicle(regnum,company,model));
			Vehicle NewVehicle=new Vehicle(regnum, company, model);
>>>>>>> main
			
			
			 System.out.println("Enter the customer phone number");
			 String phone =sc.next();
<<<<<<< HEAD
			 
			 Customer NewCustomer = CustomerDao.readspecific(phone);

			 if (NewCustomer != null) {
			        vehicleMap.put(NewCustomer, NewVehicle);
			        System.out.println("Vehicle added for customer: " + NewCustomer.getPh_no());
			    } else {
			        System.out.println("Customer not found with phone number: " + phone);
			    }
			 
			VehicleDao.write(vehicleMap);
			VehicleDao.writeVehicle(VehicleSet);
=======
			 Customer NewCustomer = CustomerDao.readspecific(phone);

			 for(Customer customer : CustomerSubmenu.CustomerSet) {
				 if(phone.equals(customer.getPh_no())) {
					 Vehiclesubmenu.vehicleMap.put(NewCustomer,NewVehicle);
				 }
				 
			 }
			 
			//VehicleDao.writeVehicle(VehicleSet);
>>>>>>> main
					
				break;
				
			case 2:
				
				
<<<<<<< HEAD
			VehicleSet=VehicleDao.readVehicle();
=======
				//VehicleSet=VehicleDao.readVehicle();
>>>>>>> main
				if (VehicleSet.isEmpty()) {
                System.out.println("No vehicle found.");
            } else {
            	for (Vehicle vehicle : VehicleSet) {
                    System.out.println(vehicle);
			}
            }
				break;
				
				
			case 3:
				
<<<<<<< HEAD
				HashSet<Customer> customer = CustomerDao.readCustomer();
				System.out.println("Enter the Customer phone number :");
				String ph=sc.next();
				 for(Customer ele : customer) {

					 if(ele.getPh_no().equals(ph)) {
				           Vehicle vehicle = Vehiclesubmenu.vehicleMap.get(ele);

						 System.out.println(ph+ ":"+vehicle);
=======
				System.out.println("Enter the Customer phone number :");
				String ph=sc.next();
				 for(Customer customer : CustomerSubmenu.CustomerSet) {

					 if(customer.getPh_no().equals(ph)) {
						 System.out.println(ph+ ":"+Vehiclesubmenu.vehicleMap.get(VehicleSet));
>>>>>>> main
					 }
				 }
				 break;
				
			case 4:
				System.out.println("Enter the registered number of the car :");
				String regnumber =sc.next();
				System.out.println("select what you want to change :");
				
				for (Vehicle vehicle : VehicleSet) {
					if(regnumber.equals(vehicle.getReg_no())) {
						
								System.out.println("Enter the new number :");
								String name=sc.next();
								vehicle.setReg_no(name);

						}
					else {
						System.out.println("NO SUCH ENTRY IS PRESENT...");
					}
				}
<<<<<<< HEAD
				VehicleDao.write(vehicleMap);
				VehicleDao.writeVehicle(VehicleSet);
=======
				//VehicleDao.writeVehicle(VehicleSet);
>>>>>>> main
				break;
				
				
			case 5:
<<<<<<< HEAD
				HashSet<Vehicle> vehicle = VehicleDao.readVehicle();

				System.out.println("Enter the registered number of the car you want to delete :");
				String Cdelete =sc.next();
				for (Vehicle  ele: vehicle) {
					if(Cdelete.equals(ele.getReg_no())) {
						VehicleSet.remove(ele);
						System.out.println("The record is deleted.....");
					}
					VehicleDao.writeVehicle(VehicleSet);
=======
				System.out.println("Enter the registered number of the car you want to delete :");
				String Cdelete =sc.next();
				for (Vehicle vehicle : VehicleSet) {
					if(Cdelete.equals(vehicle.getReg_no())) {
						VehicleSet.remove(vehicle);
						System.out.println("The record is deleted.....");
						VehicleDao.writeVehicle(VehicleSet);
					}
>>>>>>> main
					
					
			
			
	
			}
		}
	}
}
}
