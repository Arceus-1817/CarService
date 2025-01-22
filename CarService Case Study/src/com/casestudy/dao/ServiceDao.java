package com.casestudy.dao;

<<<<<<< HEAD

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.security.Provider.Service;
    import java.util.HashSet;

import com.casestudy.Services;


	public class ServiceDao {



	public static void writeService(HashSet<Services> serviceSet) throws FileNotFoundException, IOException {

	try(FileOutputStream fos = new FileOutputStream(new File("Services.txt"))){

	ObjectOutputStream os = new ObjectOutputStream(fos);
	os.writeObject(serviceSet);

	}

	}

=======
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import com.casestudy.*;

public class ServiceDao implements Serializable{
	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
=======
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6
	public static HashSet<Services> readService() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try(FileInputStream fis = new FileInputStream(new File("Services.txt"))){
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashSet<Services> serviceSet = (HashSet<Services>) ois.readObject();
			return serviceSet;
			
		}
		
	}
<<<<<<< HEAD
	}


=======
>>>>>>> fafa134c7105e582897fd5989b823724c82b151c
	
	
	public static void writeService(HashSet<Services> serviceSet) throws FileNotFoundException, IOException {
		
		try(FileOutputStream fos = new FileOutputStream(new File("Services.txt"))){
			
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(serviceSet);
			
		}
		
	}
	
<<<<<<< HEAD
	public static HashSet<Services> readService() throws IOException, ClassNotFoundException {
	    File file = new File("Services.txt");
	    if (!file.exists()) {
	        // If the file doesn't exist, create a new empty HashSet and write it to the file
	        HashSet<Services> emptySet = new HashSet<>();
	        writeService(emptySet); // This will create the file with an empty set
	        return emptySet; // Return the empty set
	    }
	    
	    try (FileInputStream fis = new FileInputStream(file);
	         ObjectInputStream ois = new ObjectInputStream(fis)) {
	        return (HashSet<Services>) ois.readObject();
	    }
	}
}
=======
}
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6
>>>>>>> fafa134c7105e582897fd5989b823724c82b151c
