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
import java.util.LinkedList;

import com.casestudy.*;
	
	public class PartsDao implements Serializable{

		private static final long serialVersionUID = 1L;

		public static void writeCustomer(LinkedList<Parts> PartsList) {
				
			try(FileOutputStream fos = new FileOutputStream(new File("Parts.txt"))) {
				
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject(PartsList);
				
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
			
		}
		
		public static LinkedList<Parts> readParts() throws FileNotFoundException, IOException, ClassNotFoundException {
			
			
			
			try(FileInputStream fis = new FileInputStream(new File("Parts.txt"))){
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				@SuppressWarnings("unchecked")
				LinkedList<Parts> PartsList = (LinkedList<Parts>) ois.readObject();
				return PartsList;
				
			}
			
		}
	}
