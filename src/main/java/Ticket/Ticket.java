package Ticket;

/******************************************************************
 * FILE:     Ticket.java
 * PURPOSE:  Class containing constructor methods and getters and setters for the Ticket object.
 * DATE:     04/06/2023
 *******************************************************************/

public class Ticket {
    private String startStreetName;
    private String startStreetType;
    private String endStreetName;
    private String endStreetType;

    public Ticket(String startStreetName, String startStreetType, String endStreetName, String endStreetType)
    {
        this.startStreetName = startStreetName;
        this.startStreetType = startStreetType;
        this.endStreetName = endStreetName;
        this.endStreetType = endStreetType;
    }

    public String getStartStreetName() {
        return startStreetName;
    }

    public String getStartStreetType() {
        return startStreetType;
    }
    public String getEndStreetName() {
        return endStreetName;
    }

    public String getEndStreetType()
    {
        return endStreetType;
    }
}
