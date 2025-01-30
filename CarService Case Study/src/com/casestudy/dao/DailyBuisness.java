package com.casestudy.dao;

import java.io.*;
import java.util.HashMap;
import com.casestudy.Date; // Assuming Date is a custom class

public class DailyBuisness {

    public static void writeBuisness(HashMap<Date, String> map) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("DailyBuisness.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(map);
        } catch (IOException e) {
            throw new IOException("Error writing to DailyBuisness.txt", e);
        }
    }

    public static HashMap<Date, String> readBuisness() throws IOException, ClassNotFoundException {
        File file = new File("DailyBuisness.txt");
        if (!file.exists()) {
            // Return an empty map if the file doesn't exist
            return new HashMap<>();
        }
        
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (HashMap<Date, String>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("DailyBuisness.txt not found");
        } catch (IOException e) {
            throw new IOException("Error reading from DailyBuisness.txt", e);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error in deserialization - class not found", e);
        }
    }
}
