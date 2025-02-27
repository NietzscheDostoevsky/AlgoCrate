package algocrate.dataStructures;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DateTest {

    @Test
    public void testValidDateConstructor() {
        Date date = new Date(12, 25, 2023);
        assertEquals(date.month(), 12);
        assertEquals(date.day(), 25);
        assertEquals(date.year(), 2023);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidDateConstructor() {
        new Date(2, 30, 2023); // Feb 30 does not exist
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidMonth() {
        new Date(13, 1, 2023); // Invalid month
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidDateStringFormat() {
        new Date("13/01/2023"); // Invalid month in string format
    }

    @Test
    public void testLeapYearNextDay() {
        Date leapDay = new Date(2, 28, 2024); // Leap year
        assertEquals(leapDay.next().toString(), "2/29/2024");

        Date nonLeapDay = new Date(2, 28, 2023); // Not a leap year
        assertEquals(nonLeapDay.next().toString(), "3/1/2023");
    }


    @Test
    public void testNextDate() {
        Date date1 = new Date(12, 31, 2023);
        Date next1 = date1.next();
        assertEquals(next1.toString(), "1/1/2024"); // Should be Jan 1, 2024

        Date date2 = new Date(2, 28, 2024); // Leap year
        Date next2 = date2.next();
        assertEquals(next2.toString(), "2/29/2024");

        Date date3 = new Date(2, 28, 2023); // Non-leap year
        Date next3 = date3.next();
        assertEquals(next3.toString(), "3/1/2023");
    }

    @Test
    public void testComparison() {
        Date earlier = new Date(1, 1, 2023);
        Date later = new Date(12, 31, 2023);

        assertTrue(earlier.isBefore(later));
        assertTrue(later.isAfter(earlier));
        assertEquals(earlier.compareTo(new Date(1, 1, 2023)), 0); // Same date should return 0
    }

    @Test
    public void testHashCode() {
        Date date1 = new Date(5, 15, 2023);
        Date date2 = new Date(5, 15, 2023);
        Date date3 = new Date(5, 16, 2023);

        assertEquals(date1.hashCode(), date2.hashCode()); // Same date, same hash
        assertNotEquals(date1.hashCode(), date3.hashCode()); // Different date, different hash
    }

    @Test
    public void testEquals() {
        Date date1 = new Date(10, 20, 2023);
        Date date2 = new Date(10, 20, 2023);
        Date date3 = new Date(10, 21, 2023);

        assertEquals(date1, date2); // Same date
        assertNotEquals(date1, date3); // Different date
        assertNotEquals(date1, null); // Null should not be equal
        assertNotEquals(date1, "10/20/2023"); // Different type should not be equal
    }

    @Test
    public void testToStringFormat() {
        Date date = new Date(4, 5, 2023);
        assertEquals(date.toString(), "4/5/2023");
    }
}
