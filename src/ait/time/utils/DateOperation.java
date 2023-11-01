package ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {
    public static int getAge(String birthDate) {
        LocalDate date = parseDate(birthDate);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        String[] res = Arrays.copyOf(dates, dates.length);
        Arrays.sort(res, (d1, d2) -> parseDate(d1).compareTo(parseDate(d2)));
        return res;
    }

    private static LocalDate parseDate(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (date.contains("-")) {
            return LocalDate.parse(date);
        } else {
            return LocalDate.parse(date, df);
        }
    }

}