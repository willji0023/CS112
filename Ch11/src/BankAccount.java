public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) throws NegativeStartingBalanceException {
        this.name = name;
        if (balance >= 0){
            this.balance = balance;
        } else {
            throw new NegativeStartingBalanceException(balance);
        }
    }

    public void writeCheck(double amount) throws InsufficientFundsException {
        if (amount <= balance){
            balance -= amount;
        } else {
            throw new InsufficientFundsException(balance, amount);
        }
    }

    public String toString(){
        String result = "Name: " + name + "\n";
        result += "Balance: " + balance + "\n";
        return result;
    }
}
