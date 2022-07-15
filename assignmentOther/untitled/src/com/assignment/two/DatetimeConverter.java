package com.assignment.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class DatetimeConverter {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Get Choice
        int choice;
        do {
            System.out.print("1: To UTC\n2: From UTC\nEnter a choice: ");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);
        scanner.nextLine();
        boolean error;
        // Get Date
        String dateString;
        do {
            System.out.print("Enter datetime (yyyy-MM-dd HH:mm:ss) (ex: 2007-12-03 10:15:30): ");
            dateString = scanner.nextLine();
            try {
                format.parse(dateString);
                error = false;
            } catch (ParseException e) {
                System.err.println("Invalid Date time format. Please try again with a valid format.");
                error = true;
            }
        } while (error);
        // Get Zone
        System.out.print("Enter " + (choice == 1 ? "from" : "to") + " zone: ");
        String zone = scanner.nextLine();
        // Parse to new Zone
        Date date;
        if (choice == 1) {
            format.setTimeZone(TimeZone.getTimeZone(zone));
            date = format.parse(dateString);
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
        } else {
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            date = format.parse(dateString);
            format.setTimeZone(TimeZone.getTimeZone(zone));
        }
        System.out.println("Converted date time: " + format.format(date));
    }
}
