package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        if(firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("First name is invalid.");
        }else if(lastName == null || lastName.length() == 0){
            throw new IllegalArgumentException("Last name is invalid.");
        }else if(ssn == null){
            throw new IllegalArgumentException("Illegal social security number.");
        }else if(hireDate == null){
            throw new IllegalArgumentException("Hire date is required.");
        }else if(daysVacation < 0 || daysVacation > MAX_VACATION_DAYS){
            throw new IllegalArgumentException("Invalid amount of vacation days.");
        }else{
            String ssnTemp = ssn.replaceAll("-", "");
            if(ssnTemp.length() !=9){
                throw new IllegalArgumentException();
            }
            char[] chars = ssnTemp.toCharArray();
            for(char c : chars){

                if(!Character.isDigit(c)){
                    throw new IllegalArgumentException();
                }
            }
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        if(daysVacation < 0 || daysVacation > MAX_VACATION_DAYS){
            throw new IllegalArgumentException("Invalid amount of vacation days.");
        }else{
            this.daysVacation = daysVacation;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("Illegal name String.");
        }else{
            this.firstName = firstName;
        }
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if(hireDate == null){
            throw new IllegalArgumentException("Hire date is required.");
        }else{
            this.hireDate = hireDate;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() == 0){
            throw new IllegalArgumentException("Last name is invalid.");
        }else{
            this.lastName = lastName;
        }
    }

    public final String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if(ssn == null){
            throw new IllegalArgumentException();
        }
        
        String ssn2 = ssn.replaceAll("-", "");
        if(ssn2.length() !=9){
            throw new IllegalArgumentException();
        }
        char[] chars = ssn2.toCharArray();
        for(char c : chars){
            
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException();
            }
        }
        
        this.ssn = ssn;
    }
    
    
}
