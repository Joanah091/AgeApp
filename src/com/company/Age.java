package com.company;

import java.util.Calendar;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        String fName, lName, month, day, dob = null, genderDigits, idNumber = null;
        int year, century;

        final int GENDER_RANGE_1 = 0000;
        final int GENDER_RANGE_2 = 4999;
        final int GENDER_RANGE_3 = 5000;
        final int GENDER_RANGE_4 = 9999;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name:");
        fName = sc.next();

        System.out.println("Enter Last name:");
        lName = sc.next();
        System.out.println("Enter id number:");
        idNumber = sc.next();


        try {
            if (idNumber.length() == 13) {

                // get date of birth from ID number
                year = Integer.parseInt(idNumber.substring(0, 2));
                month = idNumber.substring(2, 4);
                day = idNumber.substring(4, 6);

                if (year >= 10 && year <= 99) {
                    century = 1900;

                } else {
                    century = 2000;
                }
                String tempYear = String.valueOf(century + year);
                dob = day + "/" + month + "/" + tempYear;
                System.out.println("You were born on:" + dob);

                //Get system date to calculate age
                Calendar cal = Calendar.getInstance();
                int age = cal.get(Calendar.YEAR) - Integer.parseInt(tempYear);
                System.out.println("You are " + age + " years old");


                /**
                 * Get 4 digits from id number to get genderDigits
                 */
                genderDigits = idNumber.substring(6, 10);


                if (Integer.parseInt(genderDigits) >= GENDER_RANGE_1) {
                    System.out.println("You are a " + Gender.Female);
                } else if (Integer.parseInt(genderDigits) <= GENDER_RANGE_2) {
                    System.out.println("You are a " + Gender.Female);
                } else if (Integer.parseInt(genderDigits) >= GENDER_RANGE_3) {
                    System.out.println("You are a " + Gender.Male);
 
                } else if (Integer.parseInt(genderDigits) <= GENDER_RANGE_4) {
                    System.out.println("You are a " + Gender.Male);

                } else {
                    System.out.println("Invalid ID Number");
                }

                System.out.println("This is the record of " + fName + "," + lName + "[He/She] was born on the " + dob);
            }
            else {
             System.out.println("Invalid ID Number" + "\t" + "ID number must be 13 digits!");
            }

        } catch (NumberFormatException ex) {
            System.out.println("Invalid ID number!" + "\n" + ex.getMessage() + "\n" + "Please try again");
        }

    }
}
