package com.casestudy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import com.casestudy.*;

public class ServiceDao {
	
	public static HashSet<Services> readService() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try(FileInputStream fis = new FileInputStream(new File("Services.txt"))){
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashSet<Services> serviceSet = (HashSet<Services>) ois.readObject();
			return serviceSet;
			
		}
		
	}
	
	
	public static void writeService(HashSet<Services> serviceSet) throws FileNotFoundException, IOException {
		
		try(FileOutputStream fos = new FileOutputStream(new File("Services.txt"))){
			
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(serviceSet);
			
		}
		
	}
	
}