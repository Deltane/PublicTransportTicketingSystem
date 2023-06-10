package Passenger;
/******************************************************************
 * FILE:     PassengerValidity.java
 * PURPOSE:  Class to assign passenger status based on their age and also check account status (whether expired or active)
 * DATE:     04/06/2023
 * UNUSED
 *******************************************************************/

import java.time.LocalDate;
import java.time.Period;
public class PassengerValidity {

    public static String calculateCategory(String dateOfBirth) {
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);
        int years = age.getYears();

        if (years < 18) {
            return "Student";
        } else if (years >= 60) {
            return "Senior";
        } else {
            return "Adult";
        }
    }

    //expiry checker
}