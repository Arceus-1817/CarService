package com.casestudy.submenu;

import java.util.Scanner;

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
	
	
	public static void  VSmenu(Scanner sc) {

		int VSchoice;

		while((VSchoice=menu(sc))!=0) {
			switch(VSchoice) {
			
			case 1: 
					
				break;
				
			case 2:
				break;
			
			}
		}
	}
	
}
