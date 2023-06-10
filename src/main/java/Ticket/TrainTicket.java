/******************************************************************
 * FILE:     TrainTicket.java
 * PURPOSE:  Train ticket subclass
 * DATE:     08/06/2023
 *******************************************************************/
package Ticket;
public class TrainTicket extends Ticket {
    public TrainTicket(String startStreetName, String startStreetType, String endStreetName, String endStreetType)
    {
        super(startStreetName, startStreetType, endStreetName, endStreetType);
    }
    @Override
    public String toString() {
        return "Train Origin: " + this.getStartStreetName() + " " + this.getStartStreetType() + "\nTrain destination: " + this.getEndStreetName() + " " + this.getEndStreetType();
    }
}
