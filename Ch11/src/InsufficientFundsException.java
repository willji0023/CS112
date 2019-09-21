public class InsufficientFundsException extends Exception {
    private double checkAmount;
    private double balanceAtTheTime;

    public InsufficientFundsException(double c, double d){
        super("Error: That check can't clear. Insufficient fund!");
        this.checkAmount = c;
        this.balanceAtTheTime = d;
    }

    public String getMessage(){
        String result = super.getMessage() + "\n";
        result += "Check amount: " + checkAmount + "\n";
        result += "Balance at the time: " + balanceAtTheTime + "\n";
        return result;
    }
}
