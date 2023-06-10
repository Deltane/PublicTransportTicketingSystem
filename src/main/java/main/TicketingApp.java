package main;

/******************************************************************
 * FILE:     TicketingApp.java
 * PURPOSE:  Initialises app
 * DATE:     03/06/2023
 *******************************************************************/

import TransportMainframe.TransportSimulator;

public class TicketingApp
{
    public static void main(String[] args)
    {
        System.out.println("Beginning Public Transport Ticketing System Simulator.");
        //Initialising the transport mainframe and starting the app
        TransportSimulator transportMainframe = new TransportSimulator();
        transportMainframe.init();
    }
}

