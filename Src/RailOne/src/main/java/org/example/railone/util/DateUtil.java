package org.example.railone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for date and time operations
 */
public class DateUtil {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    /**
     * Get current date in DD-MM-YYYY format
     */
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * Get current date and time
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * Get date after n days
     */
    public static String getDateAfterDays(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date(System.currentTimeMillis() + (long) days * 24 * 60 * 60 * 1000);
        return sdf.format(date);
    }

    /**
     * Get current timestamp
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Format date
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * Get formatted current date and time with specific format
     */
    public static String getFormattedDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * Get next day date
     */
    public static String getNextDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        return sdf.format(date);
    }

    /**
     * Add hours to current time
     */
    public static String addHoursToCurrentTime(int hours) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        Date date = new Date(System.currentTimeMillis() + (long) hours * 60 * 60 * 1000);
        return sdf.format(date);
    }
}
