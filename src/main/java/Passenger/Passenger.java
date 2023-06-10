package Passenger;

/******************************************************************
 * FILE:     Passenger.java
 * PURPOSE:  Passenger class with constructor methods and getters and setters for the passenger object
 * DATE:     04/06/2023
 *******************************************************************/

import Ticket.Ticket;

public class Passenger {
    private int accountNumber;
    private String firstName;
    private String surname;

    private String age;
    private Ticket ticket;

    //add if < 18 then student if > 60 then senior
    public Passenger(int accountNumber, String firstName, String surname, String age)
    {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.ticket = null;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge(){
        return age;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket inTicket) {
        this.ticket = inTicket;
    }
}
