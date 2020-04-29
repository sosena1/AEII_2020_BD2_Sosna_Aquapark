package pl.bd.aquapark.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.*;

public class DateService {
    public static boolean isDayEqual(java.sql.Date date, java.sql.Date date2) {
        Calendar cal1 = getCalendar(date);
        Calendar cal2 = getCalendar(date2);
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(YEAR) == cal2.get(YEAR);
    }

    public static List<java.sql.Date> generateDates(java.sql.Date start, java.sql.Date end)  {
        List<java.sql.Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(end);

        while (!calendar.after(endCalendar)) {
            datesInRange.add(utilDateToSqlDate(calendar.getTime()));
            calendar.add(DATE, 1);
        }

        return datesInRange;
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    public static java.sql.Date getCurrentDay() {
        return utilDateToSqlDate(new java.util.Date());
    }

    public static java.sql.Time getCurrentTime() {
        return java.sql.Time.valueOf(LocalTime.now());
    }

    public static int getDiffYears(java.util.Date date1, java.util.Date date2) {
        Calendar a = getCalendar(date1);
        Calendar b = getCalendar(date2);
        int diff = b.get(YEAR) - a.get(YEAR);

        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }


    public static Calendar getCalendar(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static Calendar getCalendar(java.sql.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static DayOfWeek getDayOfWeek(java.util.Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfWeek();
    }
}
