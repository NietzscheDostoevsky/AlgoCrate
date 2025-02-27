/******************************************************************************
 * 
 * An immutable date type for Dates
 * American date formant : MM/DD/YYYY , using this as it was used in the book I studied from, and test dataset was available in this format. 
 * 
 ******************************************************************************/


package algocrate.dataStructures;

public class Date implements Comparable<Date> {
	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // Max days per month
	
	private final int month;
	private final int day;
	private final int year; 
	
	
	//Constructor to initialize a new date from month, day and year
	public Date(int month, int day, int year) {
		//input validity check
		if (!isValid(month, day, year)) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.month = month;
		this.day = day; 
		this.year = year;
	}
	
	//Constructor to initialize a new date from a date string of format MM/DD/YYYY
	public Date(String date) {
		String [] fields = date.split("/");
		if (fields.length != 3) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.month = Integer.parseInt(fields[0]);
		this.day = Integer.parseInt(fields[1]);
		this.year = Integer.parseInt(fields[2]);
		if (!isValid(month, day, year)) {
			throw new IllegalArgumentException("Invalid date");
		}
	}
	
	public int month() {
		return this.month; 
	}
	
	public int day() {
		return this.day;
	}
	public int year() {
		return this.year;
	}
	
	// Returns next date in the calender from the current date
	public Date next() {
		if (isValid(month, day + 1, year)) 		return new Date(month, day + 1, year);
		else if (isValid(month + 1, day, year)) return new Date(month + 1, 1, year); // the current date is the last date of the month
		else 									return new Date(1, 1, year + 1); // current date is the last date of the year
	}
	
	// compare two dates chronologically
	public boolean isAfter(Date that) {
		return compareTo(that) > 0;
	}
	
	public boolean isBefore(Date that) {
		return compareTo(that) < 0; 
	}
	
	// is the date a valid date 
	private static boolean isValid(int month, int day, int year) {
		if (month < 1 || month > 12) return false;
		if (day < 1 || day > DAYS[month]) return false; 
		if ( month == 2 && day == 29 && !isLeapYear(year)) return false;
		return true;
	}
	
	private static boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false; 
		return year % 4 == 0;
	}

	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
