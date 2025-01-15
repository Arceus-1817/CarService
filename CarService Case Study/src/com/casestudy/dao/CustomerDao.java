package com.casestudy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import com.casestudy.Customer;


public class CustomerDao implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void writeCustomer(HashSet<Customer> customer) {
			
		try(FileOutputStream fos = new FileOutputStream(new File("Customer.txt"))) {
			
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(customer);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public static HashSet<Customer> readCustomer() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		
		try(FileInputStream fis = new FileInputStream(new File("Customer.txt"))){
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			HashSet<Customer> customer = (HashSet<Customer>) ois.readObject();
			return customer;
			
		}
		
	}