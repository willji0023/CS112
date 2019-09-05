public class NegativeStartingBalanceException extends Exception {
    private double theOffendingNumber;

    public NegativeStartingBalanceException(double badNumber){
        super("Error: Can't have a negative starting balance");
        theOffendingNumber = badNumber;
    }

    public double getTheOffendingNumber(){
        return theOffendingNumber;
    }
}
