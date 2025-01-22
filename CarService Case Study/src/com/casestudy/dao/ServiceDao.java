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
import java.util.HashSet;

import com.casestudy.*;

public class ServiceDao {
	
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
	
	
	public static void writeService(HashSet<Services> serviceSet) throws FileNotFoundException, IOException {
		
		try(FileOutputStream fos = new FileOutputStream(new File("Services.txt"))){
			
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(serviceSet);
			
		}
		
	}
	
}
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6
