package com.casestudy.submenu;

import java.util.HashMap;
import java.util.Scanner;

import com.casestudy.Customer;

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
	
	static HashMap<String, String> hashMap = new HashMap<>();
	
	public static void  VSmenu(Scanner sc) {

		int VSchoice;

		while((VSchoice=menu(sc))!=0) {
			switch(VSchoice) {
			
			case 1: 
				System.out.println("Enter the Reg_no,Company,model of the vehicle :");
				String Reg_no=sc.next();
				String Company=sc.next();
				String model=sc.next();
				hashMap.add(new Customer(Reg_no,Company,model));
					
				break;
				
			case 2:
				break;
			
			}
		}
	}
	
}
