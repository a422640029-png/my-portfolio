/*
 * DayOfWeekCalculator.java
 *
 * Calculates the day of the week for a valid Gregorian calendar date.
 * Reference date: November 1, 2026 (Sunday).
 */

import java.util.Scanner;

public class DayOfWeekCalculator {

    // Check whether a year is a leap year.
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
    }

    // Return the number of days in a month.
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    // Calculate the signed number of days from startYear to endYear.
    public static long calculateYearDays(int startYear, int endYear) {
        long totalDays = 0;

        if (startYear < endYear) {
            for (int year = startYear; year < endYear; year++) {
                totalDays += isLeapYear(year) ? 366 : 365;
            }
        } else {
            for (int year = endYear; year < startYear; year++) {
                totalDays -= isLeapYear(year) ? 366 : 365;
            }
        }

        return totalDays;
    }

    // Count the days before a date within its own year.
    // January 1 has an offset of 0.
    public static int getDayOfYearOffset(int day, int month, int year) {
        int totalDays = 0;

        for (int currentMonth = 1; currentMonth < month; currentMonth++) {
            totalDays += getDaysInMonth(currentMonth, year);
        }

        return totalDays + day - 1;
    }

    // Validate the entered date.
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12) {
            return false;
        }

        return day >= 1 && day <= getDaysInMonth(month, year);
    }

    private static final String[] DAYS_OF_WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom Date & Day of the Week Calculator ===");

        System.out.print("Enter target day (e.g. 7): ");
        int targetDay = scanner.nextInt();

        System.out.print("Enter target month (e.g. 11): ");
        int targetMonth = scanner.nextInt();

        System.out.print("Enter target year (e.g. 2005): ");
        int targetYear = scanner.nextInt();

        if (!isValidDate(targetDay, targetMonth, targetYear)) {
            System.out.println("Invalid date. Please enter a valid Gregorian date.");
            scanner.close();
            return;
        }

        // Known reference date: November 1, 2026 (Sunday).
        int refDay = 1;
        int refMonth = 11;
        int refYear = 2026;
        int refDayOfWeekIndex = 0;

        // Calculate the difference between the two dates.
        long totalCounter = calculateYearDays(refYear, targetYear);

        totalCounter += getDayOfYearOffset(
                targetDay, targetMonth, targetYear);

        totalCounter -= getDayOfYearOffset(
                refDay, refMonth, refYear);

        // Normalize the result to an index from 0 to 6.
        int dayIndex = (int) Math.floorMod(
                refDayOfWeekIndex + totalCounter, 7);

        System.out.println("\n[+] Algorithm executed successfully!");
        System.out.println(
                "The day of the week for "
                + targetDay + "/" + targetMonth + "/" + targetYear
                + " is: " + DAYS_OF_WEEK[dayIndex]
        );

        scanner.close();
    }
}
