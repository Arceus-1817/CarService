package com.casestudy.submenu;

import java.util.HashSet;
import java.util.Scanner;

import com.casestudy.Customer;

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
	
	public static void  CSmenu(Scanner sc) {

		int CSchoice;

		while((CSchoice=menu(sc))!=0) {
			switch(CSchoice) {
			
			case 1: 
			System.out.println("Enter the name,phone number,address of the customer :");
			String Cname=sc.next();
			String Cphone=sc.next();
			String Caddress=sc.next();
			CustomerSet.add(new Customer(Cname,Cphone,Caddress));
					
				break;
				
			case 2:if (CustomerSet.isEmpty()) {
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
					if(phone.equals(Customer.getPh_no())) {
						int Editchoice;
						while((Editchoice=EditCustomer(sc))!=0) {
							switch(Editchoice) {
							case 1:
								System.out.println("Enter the new name :");
								String name=sc.next();
								customer.setName(name);
								
							case 2:
								System.out.println("Enter the new address :");
								String address=sc.next();
								customer.setC_address(address);
							}
						}
					}else {
						System.out.println("NO SUCH ENTRY IS PRESENT...");
					}
				}
			
			}
		}
	}
	
	
}
