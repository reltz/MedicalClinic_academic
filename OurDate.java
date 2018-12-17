package assign3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* Assignment 3
 * File Name: OurDate.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 25/10/2018
 */


//Class to reference a date with day, month and year.
public class OurDate {
	private static final Calendar CALENDAR = Calendar.getInstance();
	protected static final int presentDay = CALENDAR.get(Calendar.DATE);
	protected static final int presentMonth = CALENDAR.get(Calendar.MONTH) + 1;
	protected static final int presentYear = CALENDAR.get(Calendar.YEAR);
	private int day;
	private int month;
	private int year;

	// default constructor initializes the date fields;
	public OurDate() {
		this(CALENDAR.get(CALENDAR.DATE)-1, CALENDAR.get(CALENDAR.MONTH) + 1, CALENDAR.get(CALENDAR.YEAR));

	}

	// overloaded constructor
	public OurDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);

	}

	// getter method to retrieve the day field
	public int getDay() {
		return this.day;
	}

	// getter method to retrieve the month field
	public int getMonth() {
		return this.month;
	}

	// getter method to retrieve the year field
	public int getYear() {
		return this.year;

	}

	// method to set the day
	private void setDay(int day) {
		// data control and exception handling
		//Depending on the month, the possible number for day will change.

		if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8
				|| this.month == 10 || this.month == 12) {
			if (day < 1 || day > 31) {
				throw new MedicalClinicException("The day must be between 1 and 31!");
			} else {
				this.day = day;
			}

		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if (day < 1 || day > 30) {
				throw new MedicalClinicException("The day must be between 1 and 30!");
			} else {
				this.day = day;
			}
		} else if (this.month == 2) {
			if (isLeapYear(this.year)) {
				if (day < 1 || day > 29) {
					throw new MedicalClinicException("The day must be between 1 and 29!");
				} else {
					this.day = day;
				}

			} else {
				if (day < 1 || day > 28) {
					throw new MedicalClinicException("The day must be between 1 and 28!");
				} else {
					this.day = day;
				}
			}
		}

	}

	// method to set the month
	private void setMonth(int month) {
		// data control
		if (month < 1 || month > 12) {
			throw new MedicalClinicException("Month must be value between 1 and 12! ");
		} else {
			this.month = month;
		}
	}

	// method to set the year
	private void setYear(int year) {
		// data control?
		this.year = year;
	}

	// toString method - print the date in a nice format

	public String toString() {
		return day + "/" + month + "/" + year;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	//overriden method that verify if object is equal
	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (!(obj instanceof OurDate)) {
			return false;
		}
		// casting object as OurDate
		OurDate d = (OurDate) obj;

		return (this.day == d.day && this.month == d.month && this.year == d.year);

	}

	//method to verify if the year is a leap year by using GregorianCalendar class
	public static boolean isLeapYear(int year) {
		GregorianCalendar gcal = new GregorianCalendar();
		return gcal.isLeapYear(year);
	}

}
