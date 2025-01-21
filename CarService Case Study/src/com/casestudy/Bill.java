package com.casestudy;

<<<<<<< HEAD
import java.util.GregorianCalendar;

public class Bill {

	
	public static final double gst = 12.6;
	public double Amount;
	Customer customer;
	Vehicle vehicle;
	GregorianCalendar  C=new GregorianCalendar();

	
	public void setAmount(double amount) {
		Amount = amount;
	}

	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public GregorianCalendar getC() {
		return C;
	}
	public void setC(GregorianCalendar c) {
		C = c;
	}
	public double getAmount() {
		return Amount;
	}
	@Override
	public String toString() {
		return "Bill [Amount=" + Amount + ", customer=" + customer + ", vehicle=" + vehicle + ", C=" + C + "]";
=======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;

import com.casestudy.main.*;
import com.casestudy.*;

public class Bill implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar c = new GregorianCalendar();
	private Customer customer;
	private Vehicle vehicle;
	private double amount;
	private double balance;
	
	public Bill() {
		
		this.amount = 0;
		
	}

	public Bill(double amount) {
		this.amount = amount;
	}
	
	
	
	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		
		this.c= c;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Bill(int day,int month,int year , double amount) {
		
		c = new GregorianCalendar(year, month, day);
		this.amount = amount;
		
	}
	
	public void printDate() {
			
		System.out.print("Todays Date: ");
		this.setC(Calendar.getInstance());
		Calendar calendar = this.getC();
		System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+ "-");
		System.out.print(calendar.get(Calendar.MONTH)+1); 
		System.out.print("-" + calendar.get(Calendar.YEAR));
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			System.out.println("    "+ "Day: "+ "Sunday");
			break;
		case 2:
			System.out.println("    "+ "Day: "+ "Monday");
			break;
		case 3:
			System.out.println("    "+ "Day: "+ "Tuesday");
			break;
		case 4:
			System.out.println("    "+ "Day: "+ "Wednesday");
			break;
		case 5:
			System.out.println("    "+ "Day: "+ "Thursday");
			break;
		case 6:
			System.out.println("    "+ "Day: "+ "Friday");
			break;
		case 7:
			System.out.println("    "+ "Day: "+ "Saturday");
			break;
		}
		
	}
	
	
	
	@Override
	public String toString() {
		return "customer=" + customer + ", vehicle=" + vehicle + ", amount=" + amount + ", balance="
				+ balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, balance, c, customer, vehicle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(c, other.c) && Objects.equals(customer, other.customer)
				&& Objects.equals(vehicle, other.vehicle);
	}

	public static void printBill(Bill bill, Customer customer, Vehicle vehicle, double serviceCost, double maintainanceCost, double repairCost, double oilChangeCost, Date date) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("################# Final Bill Summary ##################");
		System.out.println("\nCustomer: "+ customer.getName()+ "  Mobile: "+ customer.getPh_no());
		System.out.println("\nVehicle: "+ vehicle.getCompany()+ " "+ vehicle.getModel()+ "  Registration No: "+ vehicle.getReg_no());
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		bill.printDate();
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\n Description             Amount");
		System.out.println("\nService Cost:           "+ serviceCost+ "rs");
		System.out.println("\nMaintainance Cost:      "+ maintainanceCost+ "rs");
		System.out.println("\nRepair Cost:            "+ repairCost+ "rs");
		System.out.println("\nOil Change Cost:        "+ oilChangeCost+ "rs");
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\nTotal:                  "+ bill.getAmount()+ "rs");
		System.out.println("\nGST:                    "+ mainmenu.gst+ "%");
		bill.setAmount(bill.getAmount()+ ((bill.getAmount()*mainmenu.gst)/100));
		System.out.println("\nFinal Total (With GST): "+ bill.getAmount()+ "rs");
		System.out.println("\n########## Thank You For Taking Our Service! ###########\n");
		
		
//		HashMap<Date, Double> billMap = DailyBuisness.readDailyBuisness();
//		double temp = (double) billMap.get(date);
//		billMap.put(date, temp + bill.getAmount());
//		DailyBuisness.writeDailyBuisness(billMap);
		
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6
	}
	
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 9082f1fd4bca3e1acbd1ce9f01d97f6494d9d9a6
