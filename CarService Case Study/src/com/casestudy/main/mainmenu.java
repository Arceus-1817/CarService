package com.casestudy.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import com.casestudy.submenu.*;

public class mainmenu {	
	
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Customer");
		System.out.println("2. Vehicles");
		System.out.println("3. Service Request");
		System.out.println("4. Parts");
		System.out.println("5. Total sales of today");
		System.out.println("6. Sales of perticular day");
		System.out.println("********************************************");
		return sc.nextInt();
		
	}
	


	
	public static void main (String []args) {
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
				ServiceSubmenu.SSmenu(sc);
				break;
				
				
			case 4:
				PartsSubmenu.PSmenu(sc);
				break;
			
			}
		}
		
	}

}

	
