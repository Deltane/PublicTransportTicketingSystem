/******************************************************************
 * FILE:     TransportObserver.java
 * PURPOSE:  Interface for observers notifying events transmitted from TransportSimulator
 * DATE:     08/06/2023
 *******************************************************************/
package TransportMainframe;

import Passenger.Passenger;

public interface TransportObserver {
    public void passengerListUpdate (Passenger p);
}
