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
import com.casestudy.Vehicle;

public class VehicleDao implements Serializable{
	private static final long serialVersionUID = 1L;

	public static void writeVehicle(HashSet<Vehicle> vehicle) {
			
		try(FileOutputStream fos = new FileOutputStream(new File("Vehicle.txt"))) {
			
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(vehicle);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public static HashSet<Vehicle> readVehicle() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		
		try(FileInputStream fis = new FileInputStream(new File("Vehicle.txt"))){
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			HashSet<Vehicle> vehicle = (HashSet<Vehicle>) ois.readObject();
			return vehicle;
			
		}
		
	}
	
	
}
