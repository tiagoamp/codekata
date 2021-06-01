package hackerrank;

// https://www.hackerrank.com/challenges/day-of-the-programmer/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfTheProgrammer {

    public static String dayOfProgrammer(int year) {
        int day = 13;
        if (year == 1918)
            day += 13; // lost days from Feb 1st to Feb 14th
        if (isLeap(year))
            day -= 1;
        return day + ".09." + year;
    }

    public static String dayOfProgrammer_LocalDateSolution(int year) {
        LocalDate date = LocalDate.of(year, Month.JANUARY, 1).minusDays(1).plusDays(256);
        if (year == 1918)
            date = date.plusDays(13); // lost days from Feb 1st to Feb 14th
        if (year <= 1918) {
            boolean isLeapYearByJulianCalendar = year % 4 == 0;
            if (isLeapYearByJulianCalendar && !date.isLeapYear())
                date = date.minusDays(1);;
        }
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static boolean isLeap(int year) {
        if (year <= 1918)
            return year % 4 == 0;
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }


    @Test
    @DisplayName("Test sample 0")
    void test0() {
        int year = 2017;
        String expected = "13.09.2017";
        String result1 = dayOfProgrammer(year);
        String result2 = dayOfProgrammer_LocalDateSolution(year);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
    }

    @Test
    @DisplayName("Test sample 1")
    void test1() {
        int year = 2016;
        String expected = "12.09.2016";
        String result1 = dayOfProgrammer(year);
        String result2 = dayOfProgrammer_LocalDateSolution(year);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
    }

    @Test
    @DisplayName("Test sample 2")
    void test2() {
        int year = 1800;
        String expected = "12.09.1800";
        String result1 = dayOfProgrammer(year);
        String result2 = dayOfProgrammer_LocalDateSolution(year);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
    }

    @Test
    @DisplayName("Test sample 11")
    void test11() {
        int year = 1916;
        String expected = "12.09.1916";
        String result1 = dayOfProgrammer(year);
        String result2 = dayOfProgrammer_LocalDateSolution(year);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
    }

}
