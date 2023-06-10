package TransportMainframe;

/******************************************************************
 * CLASS:     TicketDistributionNotifier.java
 * PURPOSE: Outputs the ticket type, origin and destination of each passenger
 * DATE:     29/05/2023
 *******************************************************************/

import Passenger.Passenger;
import Ticket.BusTicket;
import Ticket.TrainTicket;

public class TicketClassifier implements TransportObserver {
    public void passengerListUpdate (Passenger passenger) {
        String ticketMessage = null;
        String ticketType = null;

        // Check the type of ticket the passenger has
        if (passenger.getTicket() instanceof TrainTicket) {
            ticketType = "Train";
        } else if (passenger.getTicket() instanceof BusTicket) {
            ticketType = "Bus";
        }
        // Create a message describing the ticket information
        ticketMessage = passenger.getFirstName() + " " + passenger.getSurname() + " purchased a " + ticketType
                + " ticket and is travelling from " + passenger.getTicket().getStartStreetName() + " " + passenger.getTicket().getStartStreetType() + " to " + passenger.getTicket().getEndStreetName() + " " + passenger.getTicket().getEndStreetType();

        // Print the ticket message
        System.out.println(ticketMessage);
    }
}
