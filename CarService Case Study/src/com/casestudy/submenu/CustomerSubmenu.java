package com.casestudy.submenu;

import java.util.Scanner;

public class CustomerSubmenu {
	
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Add Customer");
		System.out.println("2. Show all Customers");
		System.out.println("3. Edit Customer details");
		System.out.println("4. Delete Customer");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	
	
	public static void  CSmenu(Scanner sc) {

		int CSchoice;

		while((CSchoice=menu(sc))!=0) {
			switch(CSchoice) {
			
			case 1: 
					
				break;
				
			case 2:
				break;
			
			}
		}
	}
	
	
}
