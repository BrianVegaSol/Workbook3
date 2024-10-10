package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    //static Scanner scan = new Scanner(System.in);
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
            }
            //null when outside of while loop (idk why)
            /*String [] pipeSplit = line.split("\\|");
            String id = pipeSplit[0];*/

            //Only spits out last update to id, 80
           // System.out.println(id);

            //Scope issue due to being in while loop?
            //System.out.println(employee1.calcGrossPay());







        } catch (IOException e) {
            System.err.println("Error occurred" + e.getMessage());
        } //A throw New RuntimeException(e); may work










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
