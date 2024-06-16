package com.blubank.doctorappointment.util;

public class AppointmentUtil {
    private static final long LIMIT = 100000L;
    private static long last = 0;

    public static String generatedAppointmentCode(){

            // 5 digits.
            long id = System.currentTimeMillis() % LIMIT;
            if ( id <= last ) {
                id = (last + 1) % LIMIT;
            }
            last = id;
            return String.valueOf(last);
    }
}
