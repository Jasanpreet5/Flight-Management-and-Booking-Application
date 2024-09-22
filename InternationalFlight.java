class InternationalFlight extends Flight {
    private String carrier;
    private String country;

    public InternationalFlight(String flightNumber, String destination, String carrier, String country) {
        super(flightNumber, destination);
        this.carrier = carrier;
        this.country = country;
    }

    @Override
    public void displayInfo() {
        System.out.println("International Flight: ");
        System.out.println("\t\tFlight Number-- " + getFlightNumber() );
        System.out.println("\t\tDestination-- " + getDestination() );
        System.out.println("\t\tStatus-- " + getFlightStatus() );
        System.out.println("\t\tCarrier-- " + carrier );
        System.out.println("\t\tCountry-- " + country );
    }
}

