# Public Transport Ticketing System Project for Object-Oriented Software Engineering
Serena McPherson 19765644

# How to install via GitHub:
git clone https://github.com/Deltane/PublicTransportTicketingSystem
cd PublicTransportTicketingSystem

# How to build and run via gradle
Change to assignment directory
./gradlew build
./gradlew run

# Usage
My application takes input data from the transport_data.txt file, if a different file is to be used simply change the name in the file input method.
The data is in order of [account number], [date of account activation], [date of account expiration], [first name], [surname], [date of birth], [type of transport], [origin street name], [destination street]. 
My Public Transport Simulator application is not interactive but simply a simulator so once running there is not much more to do other than spectate how and where passengers are going to and from all in streets within Western Australia. 

# Reasoning and Justifications
My program consists of four packages each containing classes pertaining to their purpose. I implemented a Transport Observer Interface to receive notifications from the system.
Unfortunately I ran out of time to implement passenger account validity based on if their account is expired. Furthermore, I did not end up using the age method I created within the PassengerValidity class that was meant to determine the status of the passenger.
For instance, I had the intention of calculating the age and displaying whether the passenger was on a student fare, standard fare or senior fare.
