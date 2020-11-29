package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/library-fine/problem
public class LibraryFine {	

	@Test
	@DisplayName("Test sample 0")
	void testLibraryFine0() {
		int d1=9, m1=6, y1=2015;
		int d2=6, m2=6, y2=2015;
		int expected = 45;
		int result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 1")
	void testLibraryFine1() {
		int d1=5, m1=5, y1=2014;
		int d2=23, m2=2, y2=2014;
		int expected = 1500;
		int result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 2")
	void testLibraryFine2() {
		int d1=2, m1=7, y1=1014;
		int d2=1, m2=1, y2=1014;
		int expected = 3000;
		int result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
	}
	

	public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    	if (y1 > y2) return 10_000;
    	LocalDate returnedDate = LocalDate.of(y1, m1, d1);
    	LocalDate dueDate = LocalDate.of(y2, m2, d2);
    	if (returnedDate.isBefore(dueDate) || returnedDate.isEqual(dueDate))
    		return 0;
    	if (returnedDate.getMonth() == dueDate.getMonth()) {
    		int daysLate = Period.between(dueDate, returnedDate).getDays();
    		return 15 * daysLate;
    	}
    	int monthsLate = m1 - m2;
    	return 500 * monthsLate;
    }

}
