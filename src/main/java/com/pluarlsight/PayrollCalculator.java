package com.pluarlsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    private int employeeID;
    private String name;
    private double hoursWorked;
    private double payRate;

    public PayrollCalculator() {

    }
    public PayrollCalculator (int employeeID, String name, double hoursWorked, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getPayRate() {
        return payRate;
    }

    static Scanner scan = new Scanner(System.in);
    static int employeeCount = 0;

    public static void main(String[] args) {
        String fileName = "src/employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String [] pipeSplit;
           /* String id = "";
            String name;
            String hoursWorked;
            String payRate;*/
            boolean isFirstLine = true;


            while ((line = reader.readLine()) != null) {
                //continue past header to not run into parseNum issue
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }
                //Prints out raw data
                //System.out.println(line);
                pipeSplit = line.split("\\|");

                int employeeID = Integer.parseInt(pipeSplit[0]);
                String name = pipeSplit[1];
                double hourWorked = Double.parseDouble(pipeSplit[2]);
                double payRate = Double.parseDouble(pipeSplit[3]);

                PayrollCalculator employee = new PayrollCalculator(employeeID,name,hourWorked,payRate);
                //Method for pretty printing info
                employee.printEmployeeInfo(employee);

                /*System.out.println(employeeID);
                System.out.println(name);
                System.out.println(hourWorked);
                System.out.println(payRate);*/



              //double hoursWorked = Double.parseDouble(pipeSplit[2]);

            //    double hoursWorked;

           //     System.out.println(pipeSplit[2]);
              //System.out.println(hoursWorked);
                //PayrollCalculator em = new PayrollCalculator();
                //PayrollCalculator employee1 = new PayrollCalculator(pipeSplit[0],pipeSplit[1],Double.parseDouble(pipeSplit[2]),Double.parseDouble(pipeSplit[3]));
                //employee1(pipeSplit[0]);

               /* setemployeeID(pipeSplit[0]);
                name = pipeSplit[1];
                hoursWorked = pipeSplit[2];
                payRate = pipeSplit[3];*/

                //System.out.println(id);
               // System.out.println(employee1);
               // System.out.println(employee1.calcGrossPay());

                //Wont let the writer work
                //reader.close();
            }
            //null when outside of while loop (IDK why)
            /*String [] pipeSplit = line.split("\\|");
            String id = pipeSplit[0];*/

            //Only spits out last update to id, 80
           // System.out.println(id);

            //Scope issue due to being in while loop?
            //System.out.println(employee1.calcGrossPay());


        } catch (IOException e) {
            System.err.println("Error occurred" + e.getMessage());
        } //A throw New RuntimeException(e); may work

        //Part 2
        //Guessing this is for Part 1???
        /*System.out.println("Enter the name of the file employee file to process:\n Ex: employees.csv");
        fileName = scan.nextLine();*/

        //Need to append instead of write and use a buffer writer instead of writer to add ALL text

        System.out.println("Enter the name of the payroll file to create/write in:\n Ex: payroll-sept-2023.csv");
        fileName = scan.nextLine();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            System.out.println("Enter the info in the following format: id|name|gross");
            writer.write(scan.nextLine());

            // close the file when you are finished using it
            //writer.close();
        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.printStackTrace();
        }

        /* BONUS:  If the user chooses specifies a .json extension write the data as JSON instead of csv.
        For example:

        Enter the name of the file employee file to process: employees.csv
        Enter the name of the payroll file to create: payroll-sept-2023.json
        payroll-sept-2023.json
                [
                { "id": 111, "name" : "Cameron Tay", "grossPay" : 3277.65 },   { "id": 222, "name" : "James Tee", "grossPay" : 2150.00 } ]

*/

        //File Buffer ex
        /*try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("employees.csv");
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
            String text;
            for(int i = 1; i <= 10; i++) {
                text = String.format("Counting %d\n", i);
                bufWriter.write(text);       }
            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }*/

    }
    public double calcGrossPay() {
        return getHoursWorked() * getPayRate();
    }
    //Unnecessary since set from constructor parameters
    public void setEmployees (PayrollCalculator employee){
        employee.setEmployeeID(employeeID);
        employee.setName(name);
        employee.setHoursWorked(hoursWorked);
        employee.setPayRate(payRate);
    }
    public void printEmployeeInfo(PayrollCalculator employee){
        employeeCount ++;
        //setEmployees(employee);
        System.out.printf("Employee %d%n",employeeCount);
        System.out.printf("Employee ID: %d%n", getEmployeeID());
        System.out.println("Employee Name: " + getName());
        System.out.printf("Hours Worked: %.1f%n", getHoursWorked());
        System.out.printf("Pay Rate: $%.2f%n", getPayRate());
        System.out.printf("Gross Pay: $%.2f%n",employee.calcGrossPay());
        System.out.println("-------------------------");

    }
}
