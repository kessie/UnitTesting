import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kesiena Obajuwana
 */
public class DateTest {
    
	/** Testing setters to see if they work**/
	@Test
    public void setDate()
    {
        Date d1 = new Date();
        d1.setDay(22);
        d1.setMonth(2);
        d1.setYear(1992);
    } 
    
    /**Testing for hashcodes of equal and unequal dates**/
	//Should produce same hashcodes for same dates and 
	//different hashcodes for different dates
	@Test
    public void testEqual(){
		//set dates for first same and different
		Date first = new Date(30, 12, 2000);
		Date same = new Date(30, 12, 2000);
		Date different = new Date(22, 10, 1992);
		
		 //checking if equal dates produce equal hashcodes//
		  assertTrue(first.equals(same));
		  assertTrue(first.hashCode() == same.hashCode());
		 
		 //checking if unequal dates produce different hashcodes//
		   assertFalse(first.equals(null));
		   assertFalse(first.equals(different));
		   assertTrue(first.hashCode() != different.hashCode());
    }
	
	/**Testing for Illegal dates in leap year**/
	//An exception is thrown when passing an invalid date in a leap year
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDateForLeapYear()
	{
		new Date(2003, 2, 29);
		throw new IllegalArgumentException("A leap year has 29 days in feb not 28");	
	}
	
	/**Testing day at boundaries**/
	// an exception is thrown when day is negative
   @Test(expected  = IllegalArgumentException.class)
   public void negativeDay()
   {
	   new Date(-1, 1, 2000);
	   throw new IllegalArgumentException("Negative day");
   } 
   
   // an exception is thrown when day is zero
   @Test(expected =  IllegalArgumentException.class)
   public void zeroDay()
   {
	   new Date(0, 1, 2000);
	   throw new IllegalArgumentException("Zero day");
   }
   
   //an exception is thrown when day>31
   @Test(expected = IllegalArgumentException.class)
   public void highestDay()
   {
	   new Date(32, 1, 2000);
	   throw new IllegalArgumentException("Day cannot be greater than 31");
   }
   
   /** Testing month at boundaries**/
   //An Exception is thrown when month is negative
   @Test(expected  = IllegalArgumentException.class)
   public void negativeMonth()
   {
	   new Date(12, -1, 2000);
	   throw new IllegalArgumentException("Negative Month");
   } 
   
   // an exception is thrown when month is zero
   @Test(expected =  IllegalArgumentException.class)
   public void zeroMonth()
   {
	   new Date(12, 0, 2000);
	   throw new IllegalArgumentException("Zero Month");
   }
   
   //an exception is thrown when month>12
   @Test(expected = IllegalArgumentException.class)
   public void highestMonth()
   {
	   new Date(12, 13, 2000);
	   throw new IllegalArgumentException("Month cannot be greater than 13");
   }
   
   /**Testing year at boundaries**/
   //An exception is thrown when year is negative
   @Test(expected  = IllegalArgumentException.class)
   public void negativeYear()
   {
	   new Date(16, 7, -1992);
	   throw new IllegalArgumentException("Negative year");
   } 
   
   // an exception is thrown when year is zero
   @Test(expected =  IllegalArgumentException.class)
   public void zeroYear()
   {
	   new Date(16, 7, 0000);
	   throw new IllegalArgumentException("Zero year");
   }
   
   //an exception is thrown when year is greater than 9999
   @Test(expected = IllegalArgumentException.class)
   public void highestYear()
   {
	   new Date(16, 7, 10000);
	   throw new IllegalArgumentException("Year cannot be greater than 9999");
   }
   
	/** CompareTo tests comparing d1 to Date other and sorting(collections.sort)**/
	@Test
	public void compareToTests()
	{
		Date d2 = new Date(20, 3, 2003);
		Date other =  new Date(16, 3, 2002);
		//make comparisons with both dates
		d2.compareTo(other);
		ArrayList<Date> DateList = new ArrayList<Date>();
		DateList.add(d2);
		DateList.add(other);
		//Using Collections.sort in Java//
		Collections.sort(DateList);
		//prints DateList after its been sorted
		for (Date str : DateList) {
            System.out.println(str);
        }
		
	}
}
