package com.enigmacamp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateDateUtil {
    public static Date generateDate(String dateParam) {
        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateParam);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return date;
    }
}
