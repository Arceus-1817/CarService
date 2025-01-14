package com.casestudy.submenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import com.casestudy.Customer;
import com.casestudy.dao.CustomerDao;

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
	
	public static int EditCustomer(Scanner sc) {
		System.out.println("********************************************");
		System.out.println("0. Exit");
		System.out.println("1. Edit Customer name");
		System.out.println("2. Edit Customer address");
		System.out.println("********************************************");
		return sc.nextInt();
	}
	
	static HashSet<Customer> CustomerSet =new HashSet<>();
	
	public static void  CSmenu(Scanner sc) throws FileNotFoundException, ClassNotFoundException, IOException {

		int CSchoice;

		while((CSchoice=menu(sc))!=0) {
			switch(CSchoice) {
			
			case 1: 
			System.out.println("Enter the name,phone number,address of the customer :");
			CustomerSet.add(new Customer(sc.next(),sc.next(),sc.next()));
			CustomerDao.writeCustomer(CustomerSet);
					
				break;
				
			case 2:
				CustomerSet=CustomerDao.readCustomer();
				if (CustomerSet.isEmpty()) {
                System.out.println("No customers found.");
            } else {
            	for (Customer customer : CustomerSet) {
                    System.out.println(customer);
			}
            }
				break;
				
				
				
				
				
			case 3:
				System.out.println("Enter the registered phone number of the customer :");
				String phone =sc.next();
				System.out.println("select what you want to change :");
				
				for (Customer customer : CustomerSet) {
					if(phone.equals(customer.getPh_no())) {
						int Editchoice;
						while((Editchoice=EditCustomer(sc))!=0) {
							switch(Editchoice) {
							case 1:
								System.out.println("Enter the new name :");
								String name=sc.next();
								customer.setName(name);
								break;
							case 2:
								System.out.println("Enter the new address :");
								String address=sc.next();
								customer.setC_address(address);
								break;
							}
						}
					}else {
						System.out.println("NO SUCH ENTRY IS PRESENT...");
					}
				}
				CustomerDao.writeCustomer(CustomerSet);
				break;
				
				
			case 4:
				System.out.println("Enter the registered phone number of the customer you want to delete :");
				String Cdelete =sc.next();
				for (Customer customer : CustomerSet) {
					if(Cdelete.equals(customer.getPh_no())) {
						CustomerSet.remove(customer);
						System.out.println("The record is deleted.....");
						CustomerDao.writeCustomer(CustomerSet);
					}
					
					
			
			}
		}
	}
	}
	
	
}
