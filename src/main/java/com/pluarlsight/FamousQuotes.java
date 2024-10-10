package com.pluarlsight;

import java.time.LocalDate;
import java.util.Scanner;

public class FamousQuotes {
    static Scanner scan = new Scanner(System.in);
    /*EXERCISE 1
Create a newJava application named FamousQuotes.
Create an array of strings to store 10 quotes. Add 10 of your favorite quotes to the array.
Prompt the user to select a number between 1 and 10 and display that quote.
DO NOT use try/catch (yet) to handle the error.
Test the application.  Select a number that exists.  Does it work?
Enter a number that doesn't exist (any number other than 1 to 10).  What happens?
Now add exception handling to the application and retest.
BONUS:  Add a loop to the program asks the user if they want to see another saying.  If they say yes, repeat the process.  DO NOT shut the application down when if an exception occurs.  Just pick up with the next iteration.
BONUS: Allow the user to select an option that will display a random quote.



try {
  // try to execute this code
}
catch(Exception e) {
  // unhandled exceptions route here
  // and are "handled" and then suppressed }

*/
    public static void main(String[] args) {
        String userInput = "2002-10-17";
        LocalDate birthDay = LocalDate.parse(userInput);

        String [] quotes = new String[] {"Dream big, start small.",
                "Kindness is a universal language.",
                "Courage over comfort.",
                "Every moment counts.",
                "Embrace the unknown.",
                "Growth begins at the end of your comfort zone.",
                "Live simply, love deeply.",
                "Find joy in the journey.",
                "Believe in your potential.",
                "Change is the only constant."};

        System.out.println("Welcome to Daily Motivation!\n" +
                "Choose a number between 1 - 10");
        int response = scan.nextInt();

        try {
            switch (response) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    System.out.println("Quote 1: " + quotes[0]);
                    break;
                case 2:
                    System.out.println("Quote 2: " + quotes[1]);
                    break;
                case 3:
                    System.out.println("Quote 3: " + quotes[2]);
                    break;
                case 4:
                    System.out.println("Quote 4: " + quotes[3]);
                    break;
                case 5:
                    System.out.println("Quote 5: " + quotes[4]);
                    break;
                case 6:
                    System.out.println("Quote 6: " + quotes[5]);
                    break;
                case 7:
                    System.out.println("Quote 7: " + quotes[6]);
                    break;
                case 8:
                    System.out.println("Quote 8: " + quotes[7]);
                    break;
                case 9:
                    System.out.println("Quote 9: " + quotes[8]);
                    break;
                case 10:
                    System.out.println("Quote 10: " + quotes[9]);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input");

            }
        } catch (IllegalArgumentException e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }

















            scan.close();
    }
}
