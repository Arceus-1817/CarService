package com.casestudy.submenu;

import java.util.Scanner;

public class PartsSubmenu {
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Parts");
		System.out.println("2. Display all Parts");
		System.out.println("3. Edit Part price ");
		System.out.println("4. Delete Part");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	
	
	public static void  PSmenu(Scanner sc) {

		int PSchoice;

		while((PSchoice=menu(sc))!=0) {
			switch(PSchoice) {
			
			case 1: 
					
				break;
				
			case 2:
				break;
			
			}
		}
	}
}
