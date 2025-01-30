package com.casestudy;


	import java.io.Serializable;
	import java.util.Objects;

	public class Date implements Serializable{

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	private int date;
	private int month;
	private int year;

	public Date(int date, int month, int year) {
	super();
	this.date = date;

	this.month = month;

	this.year = year;
	}

	public int getDate() {
	return date;
	}
	public void setDate(int date) {
	this.date = date;
	}
	public int getMonth() {
	return month;
	}
	public void setMonth(int month) {
	this.month = month;
	}
	public int getYear() {
	return year;
	}
	public void setYear(int year) {
	this.year = year;
	}
	public static long getSerialversionuid() {
	return serialVersionUID;
	}

	@Override
	public int hashCode() {
	return Objects.hash(date, month, year);
	}

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (getClass() != obj.getClass())
	return false;
	Date other = (Date) obj;
	return date == other.date && month == other.month && year == other.year;
	}




	}


