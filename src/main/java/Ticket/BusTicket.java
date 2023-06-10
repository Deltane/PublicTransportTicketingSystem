package Ticket;

/******************************************************************
 * FILE:     BusTicket.java
 * PURPOSE:  Bus Ticket subclass
 * DATE:     04/06/2023
 *******************************************************************/

public class BusTicket extends Ticket
{

    public BusTicket(String startStreetName, String startStreetType, String endStreetName, String endStreetType)
    {
        super(startStreetName, startStreetType, endStreetName, endStreetType);
    }

    @Override
    public String toString() {
        return "Bus origin: " + this.getStartStreetName() + " Bus Destination" + this.getStartStreetType() + "\n";
    }
}
