package com.casestudy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.casestudy.*;
import com.casestudy.dao.*;
import com.casestudy.submenu.ServiceSubmenu;

public class ServiceStation {
		
	private static Bill selectVehicle(Bill bill,Scanner sc, HashMap<Customer, Vehicle> map, Date date) throws FileNotFoundException, ClassNotFoundException, IOException {
		
//		System.out.println("Enter Todays Date: ");
//		System.out.println("(dd-mm-yyyy)");
//		String dateInput = sc.nextLine();
//		String[] dateParts = dateInput.split("-"); 
//		bill.setC(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
		
		bill.printDate();
		date.convertDate(bill.getC());
		MainMenu.billMap.put(date, (double) 0);
		
		
		System.out.println("Enter Customer Mobile Number: ");
		Customer c = CustomerDao.readspecific(sc.next());
		bill.setCustomer(c);
		bill.setVehicle(map.get(c));
		Vehicle v = bill.getVehicle();
		System.out.println(v);
		
		return ServiceSubmenu.processSubMenu(bill, c, v, date);
		
		
	}
	
	public static Bill serviceStation(HashMap<Customer, Vehicle> map, Date date) throws FileNotFoundException, ClassNotFoundException, IOException {
		
			Scanner sc = new Scanner(System.in);
			HashSet<Service> ServiceSet = ServicesDao.readService();
			map = CustomerDao.readMap();
			Bill bill = new Bill();
			return selectVehicle(bill, sc, map, date);
	}
	
}