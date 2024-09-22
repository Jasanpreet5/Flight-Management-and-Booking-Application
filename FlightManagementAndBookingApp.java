import java.util.ArrayList;
import java.util.Scanner;

public class FlightManagementAndBookingApp {
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Flight findFlight(String flightNumber) throws FlightNotFoundException {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        throw new FlightNotFoundException("Flight with number '" + flightNumber + "' not found.");
    }


    public static void main(String[] args) {
        FlightManagementAndBookingApp airline = new FlightManagementAndBookingApp();
        Scanner sc = new Scanner(System.in);

        int userInput, userInput2;
        String userInput3;
        String[] arguments;
        do {
            System.out.println("******ARS MENU*******");
            System.out.println("1.  Add Flight");
            System.out.println("2.  Add Passenger");
            System.out.println("3.  Find Flight");
            System.out.println("4.  Book Flight for a Passenger");
            System.out.println("5.  Cancel Flight for a Passenger");
            System.out.println("6.  Show All Flights Booked for a Passenger");
            System.out.println("0 to exit");
            System.out.println("Enter a number using above menu: ");
            userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("1. Domestic");
                    System.out.println("2. International");
                    System.out.println("Enter: ");
                    userInput2 = sc.nextInt();
                    switch (userInput2) {
                        case 1:
                            sc.nextLine();
                            System.out.println("Enter flight number, destination and carrier separated by comma");
                            userInput3 = sc.nextLine();
                            arguments = userInput3.split(",");
                            airline.addFlight(new DomesticFlight(arguments[0], arguments[1], arguments[2]));
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Enter flight number, destination, carrier, and country separated by comma");
                            userInput3 = sc.nextLine();
                            arguments = userInput3.split(",");
                            airline.addFlight(new InternationalFlight(arguments[0], arguments[1], arguments[2], arguments[3]));
                            break;

                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter name of a Passenger: ");
                    userInput3 = sc.nextLine();
                    airline.addPassenger(new Passenger(userInput3));
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter flight number to find a flight in the system: ");
                    userInput3 = sc.nextLine();
                    try {
                        airline.findFlight(userInput3).displayInfo();
                    } catch (FlightNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter name of a Passenger: ");
                    userInput3 = sc.nextLine();
                    for (Passenger p :
                            airline.passengers) {
                        if (p.getName().equalsIgnoreCase(userInput3)) {
                            System.out.println("Enter flight number to book: ");
                            userInput3 = sc.nextLine();
                            try {
                                p.bookFlight(airline.findFlight(userInput3));
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter name of a Passenger: ");
                    userInput3 = sc.nextLine();
                    for (Passenger p :
                            airline.passengers) {
                        if (p.getName().equalsIgnoreCase(userInput3)) {
                            System.out.println("Enter flight number to cancel: ");
                            userInput3 = sc.nextLine();
                            try {
                                p.cancelFlight(userInput3);
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter name of a Passenger: ");
                    userInput3 = sc.nextLine();
                    for (Passenger p :
                            airline.passengers) {
                        if (p.getName().equalsIgnoreCase(userInput3)) {
                            p.displayBookedFlights();
                        }
                    }
                    break;
            }


        } while (userInput != 0);

    }
}

