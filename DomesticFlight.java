public class DomesticFlight extends Flight {
    private String carrier;

    public DomesticFlight(String flightNumber, String destination, String carrier) {
        super(flightNumber, destination);
        this.carrier = carrier;
    }

    public void displayInfo() {
        System.out.println("Domestic Flight: ");
        System.out.println("\t\tFlight Number-- " + getFlightNumber() );
        System.out.println("\t\tDestination-- " + getDestination() );
        System.out.println("\t\tStatus-- " + getFlightStatus());
        System.out.println("\t\tCarrier-- " + carrier );
        System.out.println();
    }
}
