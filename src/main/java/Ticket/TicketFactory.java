package Ticket;

/******************************************************************
 * FILE:     TicketFactory.java
 * PURPOSE:  Class responsible for generating tickets based on the vehicle type
 * DATE:     04/06/2023
 *******************************************************************/

public class TicketFactory {
    /**************************************************************************
     * METHOD:       generateTicket
     * EXPORTS:      None
     * ASSERTION:    Generates a ticket that's of a type corresponding to the vehicle type specified by
     the Passenger
     **************************************************************************/
    public Ticket generateTicket (String vehicleType, String startStreetName, String startStreetType, String endStreetName, String endStreetType) {
        Ticket newTicket = null;
        switch (vehicleType) {
            case "Train":
                newTicket = new TrainTicket(startStreetName, startStreetType, endStreetName, endStreetType);
                break;
            case "Bus":
                newTicket = new BusTicket(startStreetName, startStreetType, endStreetName, endStreetType);
                break;

            default:
                break;
        }
        return newTicket;
    }
}

