package com.casestudy.submenu;

import java.util.LinkedList;
import java.util.Scanner;
import com.casestudy.Parts;

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
	
	static LinkedList<Parts> PartsList=new LinkedList<>();
	
	
	public static void  PSmenu(Scanner sc) {

		int PSchoice;

		while((PSchoice=menu(sc))!=0) {
			switch(PSchoice) {
			
			case 1: 
				System.out.println("ENTER THE PARTS DETAILS(Id,NAME,PRIZE)");
				String Id=sc.next();
				String Name=sc.next();
				double Prize=sc.nextDouble();
				
				PartsList.add(new Parts(Id,Name,Prize));
				break;
			
			case 2:
				if(PartsList.isEmpty()) {
				System.out.println("No Parts Present in Garage");
				}
				else
				{
					for(Parts parts:PartsList) {
						System.out.println(parts);
		
					}
				}
				break;
			
			case 3:
				System.out.println("Enter the partId of part");
				String PartId =sc.next();
				
				for (Parts parts : PartsList) {
					if(PartId.equals(parts.getPartId())) {
						
						System.out.println("Enter the prize of part");
					   double prize=sc.nextDouble();
						parts.setPrize(prize);
						System.out.println("Parts price changed....");
						System.out.println("updated" + prize);
						}
				
				}	
				break;
			
			
		}
	
		}
	
	}
}
