public abstract class Flight {
    private String flightNumber;
    private String destination;
    private boolean isBooked; // by default, initialized to false

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public void setFlightStatus(String status) {
        if(status.equalsIgnoreCase("Booked")) isBooked = true;
        if(status.equalsIgnoreCase("Available")) isBooked = false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightStatus() {
        if (isBooked) return "Booked";
        return "Available";
    }

    public abstract void displayInfo();

}
