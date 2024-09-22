import java.util.ArrayList;

public class Passenger {
    private String name;
    private ArrayList<Flight> bookedFlights;

    public String getName() {
        return name;
    }

    public Passenger(String name) {
        this.name = name;
        this.bookedFlights = new ArrayList<>();
    }
    public void bookFlight(Flight newFlight) throws Exception {
        for (Flight flightBooked:
                bookedFlights) {
            if (newFlight.equals(flightBooked)) {
                throw new CustomerAlreadyBookedFlightException("Flight with number '" + newFlight.getFlightNumber() + "' is already Booked.");
            }
        }
            bookedFlights.add(newFlight);
            newFlight.setFlightStatus("booked");
    }

    public void cancelFlight(String flightNumber) throws Exception {
        for (Flight f:
             bookedFlights) {
            if (flightNumber.equalsIgnoreCase(f.getFlightNumber())) {
                bookedFlights.remove(f);
                f.setFlightStatus("Available");
                return;
            }

        }
        throw new FlightNotFoundException("Can't cancel. Flight with number '" + flightNumber + "' not found in your bookings.");
    }

    public void displayBookedFlights() {
        System.out.println(name + " has " + bookedFlights.size() + " Booked Flights:");
        int i=1;
        for (Flight flight : bookedFlights) {
            System.out.print(i++ + ". ");
            flight.displayInfo();
        }
    }
}




