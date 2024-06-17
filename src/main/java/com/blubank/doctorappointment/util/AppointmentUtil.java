package com.blubank.doctorappointment.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentUtil {
    private static final long LIMIT = 100000L;
    private static long last = 0;

    public static String generatedAppointmentCode() {

        // 5 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        return String.valueOf(last);
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date dateToString(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date returnDate = null;
        try {
            returnDate = formatter.parse(date);
        } catch (ParseException ignore) {
        } finally {
            return returnDate;
        }
    }

}
