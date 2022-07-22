package Salon;

import java.util.Random;

public class Employee {
    //Instance Variables
    private String empName;
    private String empPhoneNum;
    private int hours1;
    private String hours2;
    private double salary1;
    private String salary2;

    //Constructors
    public Employee() {
        empName = "No Name";
        empPhoneNum = "000-000-0000";
        hours1 = 0;
    }
    //Overloaded Constructor
    public Employee(String newEmpName, String newEmpPhoneNum) {
        empName = newEmpName;
        empPhoneNum = newEmpPhoneNum;
        hours1 = 0;
    }

    //Modifiers
    //Sets employee's name to user-inputted employee name
    //Pre: User-inputted employee's name String
    //Post: None
    public void setEmpName(String newEmpName) {
        empName = newEmpName;
    }
    //Sets employee's phone # to user-inputted employee phone #
    //Pre: User-inputted employee's phone # String
    //Post: None
    public void setEmpPhoneNum(String newEmpPhoneNum) {
        empPhoneNum = newEmpPhoneNum;
    }
    //Sets employee's hours to user-inputted hours, adds them to total hours worked,
    //and converts them to a String
    //Pre: User-inputted hours int
    //Post: None
    public void setClockInOut(int addHours) {
        hours1 += addHours;
        hours2 = ""+hours1; //Converts from int to String
    }

    //Accessors
    //Returns employee's name to main method
    //Pre: None
    //Post: Employee's name String
    public String getEmpName() {
        return empName;
    }
    //Returns employee's phone # to main method
    //Pre: None
    //Post: Employee's phone # String
    public String getEmpPhoneNum() {
        return empPhoneNum;
    }
    //Returns employee's hours to main method
    //Pre: None
    //Post: Employee's hours String
    public int getClockInOut() {
        return hours1;
    }

    //Helpers
    //Checks if an employee is the same as another employee
    //Pre: None
    //Post: Boolean value
    public boolean equals(Employee emp) { //Checks for signing in purposes
        if (empName.equals(emp.getEmpName())) {
            return true;
        }
        return false;
    }
    //Calculates employee's salary for the day, Converts value to a String
    //Pre: Employee's hours int
    //Post: None
    public void empSalary(int hours1) {
        Random rand = new Random();
        salary1 = hours1*15;
        int extraPay = rand.nextInt(3-1)+1; //Generate random integer for random extra pay
        if (extraPay == 1) {
            System.out.println("Due to good service, employee earned an extra pay of $5!");
            salary1+=5;
        } else if (extraPay == 2) {
            System.out.println("Due to good service, employee earned an extra pay of $10!");
            salary1+=10;
        }
        salary2 = ""+salary1; //Converts from int to String

    }
    //Returns employee's salary to main method
    //Pre: None
    //Post: Employee's salary String
    public String getEmpSalary() { //Returns value of employee's salary for the day
        return salary2;
    }
    //Returns employee's overall information to main method
    //Pre: None
    //Post: Employee's info String
    public String toString() { //Displays employee information
        String info = "Employee Name: " + empName
                +"\nEmployee Phone #: " + empPhoneNum;
        return info;
    }
}