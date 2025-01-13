package com.casestudy.submenu;

import java.util.Scanner;

public class ServiceSubmenu {
	public static int menu(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. New service");
		System.out.println("2. Existing service");
		System.out.println("3. Maintainance");
		System.out.println("4. Reparing");
		System.out.println("4. Engine Oil Change");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	
	
	public static void  SSmenu(Scanner sc) {

		int SSchoice;

		while((SSchoice=menu(sc))!=0) {
			switch(SSchoice) {
			
			case 1: 
					
				break;
				
			case 2:
				break;
			
			}
		}
	}
}
