package com.pluarlsight;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class FormatDates {
    public static void main(String[] args) {
        //System.out.println("Now: " + LocalDate.now());



        HashMap map = new HashMap<>();
        boolean isIsogram = false;
        String s = "aba";
        char [] stringToChar = s.toCharArray();
        for (int i = 0; i < stringToChar.length; i++) {
            map.put(s.charAt(i), i);
            if (map.get(i).equals(stringToChar)){
                isIsogram = false;
            } else {
                isIsogram = true;
            }
            }
            System.out.println(isIsogram);






        String userInput = "10/17/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDay = LocalDate.parse(userInput, formatter);
        System.out.println(birthDay);

        // Create a formatter for the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        // Format the date to the desired output
        String formattedDate = birthDay.format(outputFormatter);
        System.out.println(formattedDate);  // This will print: October 17, 2022
        System.out.println();

        LocalDateTime date = LocalDateTime.now();
        DayOfWeek day = date.getDayOfWeek();
        System.out.println(day);
        System.out.println();

        DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String mdy = date.format(monthDayYear);
        System.out.println(mdy);

        DateTimeFormatter yearMonthDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String yMD = date.format(yearMonthDay);
        System.out.println(yMD);

        DateTimeFormatter writtenDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String writDate = date.format(writtenDate);
        System.out.println(writDate);


        DateTimeFormatter writtenDateAndTime = DateTimeFormatter.ofPattern("EEEE MMM d, yyyy HH:mm");
        String writDateTime = date.format(writtenDateAndTime);
        System.out.println(writDateTime);

    }
}
