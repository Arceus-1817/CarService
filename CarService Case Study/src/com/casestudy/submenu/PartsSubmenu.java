package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import com.casestudy.Customer;
import com.casestudy.Parts;
import com.casestudy.dao.CustomerDao;
import com.casestudy.dao.PartsDao;

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
	
	
	public static void  PSmenu(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {

		int PSchoice;

		while((PSchoice=menu(sc))!=0) {
			switch(PSchoice) {
			
			case 1: 
				System.out.println("ENTER THE PARTS DETAILS(Id,NAME,PRIZE)");
				
				PartsList.add(new Parts(sc.next(),sc.next(),sc.nextDouble()));
				PartsDao.readParts();
				PartsDao.writeCustomer(PartsList);
				break;
			
			case 2:
				PartsList=PartsDao.readParts();
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
				PartsDao.readParts();
				PartsDao.writeCustomer(PartsList);
				break;
				
			case 4:
				System.out.println("Enter the parts id you want to delete :");
				String Cdelete =sc.next();
				for (Parts parts : PartsList) {
					if(Cdelete.equals(parts.getPartId())) {
						PartsList.remove(parts);
						System.out.println("The record is deleted.....");
					}
					PartsDao.readParts();
					PartsDao.writeCustomer(PartsList);
					
					
			
			}
			
			
		}
	
		}
	
	}
}
