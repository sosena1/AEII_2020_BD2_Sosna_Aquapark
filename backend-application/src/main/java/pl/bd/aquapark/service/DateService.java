package pl.bd.aquapark.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DateService {
    public static boolean isDayEqual(Date date, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date);
        cal2.setTime(date2);
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    public static List<Date> generateDates(Date start, Date end)  {
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(end);

        while (!calendar.after(endCalendar)) {
            datesInRange.add(utilDateToSqlDate(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }

        return datesInRange;
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
