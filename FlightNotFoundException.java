public class FlightNotFoundException extends Exception{
    /**
     * constructor with message parameter to save parameter to exception's message value using Exception class constructor
     * @param message
     */
    public FlightNotFoundException(String message){
       // using Exception class constructor to set user specified message to Exception message instance variable
        super(message);
    }
}
