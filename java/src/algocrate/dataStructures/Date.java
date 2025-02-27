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
	    String[] fields = date.split("/");
	    if (fields.length != 3) {
	        throw new IllegalArgumentException("Invalid date format. Expected MM/DD/YYYY");
	    }
	    
	    int month, day, year;
	    try {
	        month = Integer.parseInt(fields[0]);
	        day = Integer.parseInt(fields[1]);
	        year = Integer.parseInt(fields[2]);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid date components. Must be numbers.");
	    }

	    if (!isValid(month, day, year)) {
	        throw new IllegalArgumentException("Invalid date");
	    }
	    
	    this.month = month;
	    this.day = day;
	    this.year = year;
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
		if (isValid(month, day + 1, year)) 		return new Date(month, day + 1, year); // move to the next day if it's valid
		else if (isValid(month + 1, 1, year))   return new Date(month + 1, 1, year); // if its not valid, move to the next month
		else 									return new Date(1, 1, year + 1); // if its last day of the year, reset to January 1st of the next year. 
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
	public int compareTo(Date that) {
		if (this.year < that.year) 	 return -1;
		if (this.year > that.year) 	 return 1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return 1;
		if (this.day < that.day) 	 return -1;
		if (this.day > that.day)     return 1;
		return 0;
	}
	
	@Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Date that = (Date)other;
		return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);
	}
	
	@Override
	public int hashCode() {
	    int result = 17;
	    result = 31 * result + year;
	    result = 31 * result + month;
	    result = 31 * result + day;
	    return result;
	}

}
