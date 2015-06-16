//package Revision;
/**
 *
 * @author Kesiena Obajuwana
 * <p>Developing With unit Tests and Version Control</p>
 */
public class Date implements Comparable<Date>{
    
    private static final int[] DaysOfMonth = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    
    /**Instance variables**/
    
    private int day;
    private int month;
    private int year;
    
    /**Instance methods**/
    public Date() {
        
    }

   public Date(int day){
        this.day = day;     
    }
    
    public Date(int day, int month){
        this.day = day;
        this.month = month;
    }
    
    /** Checks for date validity and
     *  also considers leap year
     *  @throws IllegalArgumentException if date isn't valid**/
    public static boolean isValid(int d, int m, int y){
        if (m < 1 || m > 12) 
            return false;
        if (d < 1 || d > DaysOfMonth[m])
            return false;
        if (m == 2 && d == 29 && !isALeapYear(y))
            return false;
        return true;   
    }
    
    /**
     * Checks if year is a leap year or not
     * @param y year**/
    private static boolean isALeapYear(int y) {
		if (y % 400 == 0) 
			return true;
		if (y % 100 == 0)
			return false;
		return  y % 4 == 0;
	}
    
    /**
     * Constructor - Date(d: int, m:int,y:int)
     * 
     * @param day
     * @param month
     * @param year
     * 
     * @throws IllegalArgumentException if day, month or year are invalid
     **/
	public Date(int day, int month, int year){
        if (!isValid(day, month, year))throw new IllegalArgumentException("Invalid date");
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
	/**
	 * Extra Constructor - Date(String date)
	 * <p> The date is supplied as a string containing three integer
	 * values for day, month and year. Values must be separated by a 
	 * hyphen(-)</p> 
	 * @param date string containing day, month and year
	 * @throws IllegalArgumentException("Invalid Date")
	 * if date(YYYY-MM-DD) is invalid
	 * **/
     public Date(String date) {
        String[] fields = date.split("-");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        month = Integer.parseInt(fields[0]);
        day   = Integer.parseInt(fields[1]);
        year  = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
    } 
     
    
    /**Getters and Setters for date, month and year**/
    /**@return Day component of date**/
    public int getDay(){
        return day;    
    }
    /** setter for day component of Date**/
    public void setDay(int d){
        day = d;   
    }
    /**@return Month component of date**/
    public int getMonth(){
        return month;    
    }
    
    /** setter for year component of Date**/
    public void setMonth(int m){
       month = m;  
    }
    /**@return Year component of date**/
    public int getYear(){
        return year;   
    }
    
    /** setter for year component of Date**/
    public void setYear(int yyyy){
        year = yyyy;   
    }
    
    /** toString method 
     * formats date as string with day, month and year
     * zeroes are added to values if needed and separated by a hyphen
     * @return string representation in ISO 8601 format**/
    @Override
    public String toString(){
        return String.format( "%04d-%02d-%02d", year,month,day);  
    }


	/** Hash-code generated using source button on eclipse
	 *  <p> Allows Date objects to work correctly in hash-based
	 *  containers</p>
	 *  <p> Equal dates should have same hash-codes and different dates
	 *  different hash-codes</p>
	 *  @return Hash-code for this date**/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	/** Equals generated using source button on eclipse
	 *  @return true if equals to the other and false otherwise**/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/** <p>CompareTo method which compares day, month and year of 
	 *   this.date to the day, month and year of other.date
	 *   and returns -1 if less than, +1 if greater than
	 *   and 0 if equals </p> **/
    public int compareTo(Date other){
    	if (this.year < other.year) return -1;
    	if (this.year > other.year) return +1;
    	if (this.year == other.year) return 0;
    	if (this.month < other.month) return -1;
    	if (this.month > other.month) return +1;
    	if (this.month == other.month) return 0;
    	if (this.day < other.day) return -1;
    	if (this.day > other.day) return +1;
    	if (this.day == other.day) return 0;
    	return 0;
    }
   
} 
