package basic;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DayBetweenDates {

  // To store number of days in
  // all months from January to Dec.
  private static Map<Integer, Integer> months = new HashMap<>();

  static {
    months.put(1, 31);
    months.put(2, 28);
    months.put(3, 31);
    months.put(4, 30);
    months.put(5, 31);
    months.put(6, 30);
    months.put(7, 31);
    months.put(8, 31);
    months.put(9, 30);
    months.put(10, 31);
    months.put(11, 30);
    months.put(12, 31);
  }


  private static class Date {
    public final int day;
    public final int month;
    public final int year;

    private Date(final int day, final int month, final int year) {
      this.day = day;
      this.month = month;
      this.year = year;
    }
  }


  public static void main(String[] args) {
    Date from = new Date(10, 9, 2021);
    Date to = new Date(13, 9, 2021);
    LocalDate fromDate = LocalDate.of(from.year, from.month, from.day);
    LocalDate toDate = LocalDate.of(to.year, to.month, to.day);
    int days = days(from, to);
    System.out.println(days);

    Duration between = Duration.between(fromDate, toDate);
    System.out.println(between);
  }

  private static int days(Date from, Date to) {
    int daysFrom = getDays(from);
    int daysTo = getDays(to);
    return daysTo - daysFrom;
  }

  private static int getDays(final Date date) {
    int days = date.day;

    // get days of years with just 365 days
    days += date.year * 365;

    // now add 1 day extra for all the leap years
    int leapYears = numberOfLeapYearsExcludingCurrentYear(date.year - 1);
    days += leapYears;

    if (currentYearIsLeapYear(date.year)) {
      days += 1;
    }

    int daysOfAllTheMonthsInCurrentYear = getDaysOfMonths(date.month);
    days += daysOfAllTheMonthsInCurrentYear;
    return days;
  }

  private static boolean currentYearIsLeapYear(final int year) {
    return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
  }

  private static int getDaysOfMonths(final int month) {
    return months.get(month);
  }

  private static int numberOfLeapYearsExcludingCurrentYear(int year) {
    return (year / 4) + (year / 400) - (year / 100);
  }

}
