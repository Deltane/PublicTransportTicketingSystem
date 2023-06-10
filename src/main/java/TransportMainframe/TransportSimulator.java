/******************************************************************
 * CLASS:     TransportCentre.java
 * PURPOSE:  Class that is responsible for issuing tickets to passengers, and stores a list
 of passengers. This class is also a subject that generates the event of a passenger
 being issued a new ticket, and has a CentreObserver which listens for this event
 to prompt the details of this ticket issuance to the console.
 * DATE:     05/06/2023
 *******************************************************************/
package TransportMainframe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import Passenger.Passenger;
import Passenger.PassengerValidity;
import Ticket.Ticket;
import Ticket.TicketFactory;
//import Utilities.Utilities;

public class TransportSimulator {
    private List<Passenger> passengers;
    private List<TransportObserver> observers;

    public TransportSimulator() {
        passengers = new ArrayList<>();
        observers = new ArrayList<>();
    }

    /**************************************************************************
     * METHOD:       init
     * IMPORTS:      None
     * EXPORTS:      None
     * ASSERTION:    Initializes the transport centre to start issuing tickets to passengers,
     store a list of these passengers that have been issued a ticket and
     start simulating the travels of each passenger based on the ticket details.
     **************************************************************************/
    public void init () {
        // File IO variables
        FileInputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader br;
        String line;
        String inputFileName = "transport_data.txt";

        System.out.println("Transport centre has opened for the day ...\n");

        //observe the distribution of tickets to passengers
        observers.add(new TicketClassifier());

        try {
            inputStream = new FileInputStream(inputFileName);
            reader = new InputStreamReader(inputStream);
            br = new BufferedReader(reader);
            line = br.readLine();

            while (line != null) {
                //Added small delay for smooth display of data
                Thread.sleep(2000);
                //Splits txt file
                String[] data = line.split(" ");
                //Assigning each column to their correlating data for ease of usability
                int accountNumber = Integer.valueOf(data[0]);
                String accountOpen = data[1];
                String accountExpire = data[2];
                String firstName = data[3];
                String surname = data[4];
                String age = PassengerValidity.calculateCategory(data[5]);
                String vehicleType = data[6];
                String startStreetName = data[7];
                String startStreetType = data[8];
                String endStreetName = data[9];
                String endStreetType = data[10];

                //new passenger object
                Passenger newPassenger = new Passenger(accountNumber, firstName, surname, age);

                //new ticket issued
                issueTicket(newPassenger, vehicleType, startStreetName, startStreetType, endStreetName, endStreetType);

                //adds new passenger with new issued ticket to passengers list
                passengers.add(newPassenger);
                line = br.readLine();
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
        } catch (IOException e2) {
            System.out.println("Unable to read file");
        } catch (InterruptedException e3) {
            System.out.println("Thread error");
            e3.printStackTrace();
        }
    }
    /**************************************************************************
     * METHOD:       issueTicket
     * IMPORTS:      (Passenger) passenger, String vehicleType, String startStreetName, String startStreetType, String endStreetName, String endStreetType
     * EXPORTS:      None
     * ASSERTION:    Takes in a newly created Passenger object, generates a new ticket with the TicketFactory
     based on the vehicle type specified by the passenger, and injects the Ticket dependency into
     the new Passenger object. Once the passenger has been issued a ticket, notify the observers
     **************************************************************************/
    public void issueTicket (Passenger passenger, String vehicleType, String startStreetName, String startStreetType, String endStreetName, String endStreetType) {
        TicketFactory ticketFactory = new TicketFactory();  // FACTORY 
        Ticket newTicket = ticketFactory.generateTicket(vehicleType, startStreetName, startStreetType, endStreetName, endStreetType);
        passenger.setTicket(newTicket); // DEPENDENCY INJECTION
        notifyObservers(passenger);
    }
    /**************************************************************************
     * METHOD:       addObserver
     * IMPORTS:      (TransportObserver) observer
     * EXPORTS:      None
     * ASSERTION:    Adds a CentreObserver to list of observers to listen for all
     ticket issuances.
     **************************************************************************/
    public void addObserver (TransportObserver observer) {
        observers.add(observer);
    }

    /**************************************************************************
     * METHOD:       removeObserver
     * IMPORTS:      (CentreObserver observer)
     * EXPORTS:      None
     * ASSERTION:    Removes specified CentreObserver from list of observers
     **************************************************************************/
    public void removeObserver (TransportObserver observer) {
        observers.remove(observer);
    }

    /**************************************************************************
     * METHOD:       notifyObservers
     * IMPORTS:      (Passenger) passenger
     * EXPORTS:      None
     * ASSERTION:    Notifies CentreObservers once a new Passenger has been issued
     a ticket
     **************************************************************************/
    public void notifyObservers (Passenger passenger) {
        for (TransportObserver transportObserver : observers) {
            transportObserver.passengerListUpdate(passenger);
        }
    }
}