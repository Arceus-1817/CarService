package com.casestudy.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.casestudy.Bill;
import com.casestudy.Date;
import com.casestudy.Vehicle;
import com.casestudy.sales;
import com.casestudy.dao.CustomerDao;
import com.casestudy.dao.DailyBuisness;
import com.casestudy.dao.VehicleDao;
import com.casestudy.submenu.*;

public class mainmenu {	
	
	public static String gst;




	public static int menu(Scanner sc) {
		int choice;
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Customer");
		System.out.println("2. Vehicles");
		System.out.println("3. Service Request");
		System.out.println("4. Parts");
		System.out.println("5. Total sales of today");
		System.out.println("6. Sales of perticular day");
		System.out.println("********************************************");
		
		choice = sc.nextInt();
		return choice;
		
	}
	
	
	
	private static void todayBuisness() throws FileNotFoundException, ClassNotFoundException, IOException {

		HashMap<Date, String> map = DailyBuisness.readBuisness();
		Calendar c = Calendar.getInstance();
		// System.out.println(Double.parseDouble(map.get(new Date(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) +1 , Calendar.getInstance().get(Calendar.YEAR)))));
		// Double amount = Double.parseDouble(map.get(new Date(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) +1 , c.get(Calendar.YEAR))));
		System.out.println("Date : "+ c.get(Calendar.DAY_OF_MONTH)+ "-" + (c.get(Calendar.MONTH)+1 )+ "-" + c.get(Calendar.YEAR));
		System.out.println("Todays Buisness:          "+ map.get(new Date(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) +1 , c.get(Calendar.YEAR)))+ "rs");

		}

		private static void dayBuisness(Date d) throws FileNotFoundException, ClassNotFoundException, IOException {

		HashMap<Date, String> map = DailyBuisness.readBuisness();
		Double amount = Double.parseDouble(map.get(d));
		System.out.println("Buisness of Day: "+ d.getDate()+ "-"+ d.getMonth()+"-"+ d.getYear()+ "          "+ ": "+ amount+ "rs");

		}
	
	

	
	public static void main (String []args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to Our Shop......   :)");
		System.out.println("Select what you want to do :");
		int ch;
		while((ch=menu(sc))!=0) {
			switch(ch) {
			
			case 1: 
				CustomerSubmenu.CSmenu(sc);
			
				break;
				
				
								
			case 2:
				Vehiclesubmenu.VSmenu(sc);
				break;
			
				
			case 3:
				ServiceSubmenu.processSubMenu();
				break;
				
				
			case 4:
				PartsSubmenu.PSmenu(sc);
				break;
				
			case 5: todayBuisness();
				break;
			
			case 6: 
				System.out.println("Enter the day/month/year");
				dayBuisness(new Date(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			
			}
		}
		
	}

}

	
