package com.internal.experimental.ocp8.datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConvertTimezone {

    public static void main(String[] argv) {

        SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy hh:mm:ss a");
        String dateInString = "1/4/2018 08:06:00 PM";
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Budapest"));
        try {

            Date clientDate = formatter.parse(dateInString);
            System.out.println(formatter.format(clientDate));
            
            formatter.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
            String serverDate = formatter.format(clientDate);
            System.out.println(serverDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}