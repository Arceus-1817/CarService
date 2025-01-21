package com.casestudy.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import com.casestudy.submenu.*;

public class mainmenu {	
	
<<<<<<< HEAD
	public static double gst;
=======
	public static String gst;
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6




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
				ProcessSubMenu.processMenu(sc);
				break;
				
				
			case 4:
				PartsSubmenu.PSmenu(sc);
				break;
			
			}
		}
		
	}

}

	
