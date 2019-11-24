public class CustomerBalances {
    public int id;
    private double last, high, low;

    public CustomerBalances(int id, String initialBalance) {
        this.id = id;
        double balance = Double.parseDouble(initialBalance.substring(1));
        last = balance;
        high = balance;
        low = balance;
    }

    public void add(String incomingBalance) {
        double balance = Double.parseDouble(incomingBalance.substring(1));
        last = balance;
        if (high < balance)
            high = balance;
        else if (low > balance)
            low = balance;
    }

    public String getLast() {
        return String.format("$%.2f", last);
    }

    public String getHigh() {
        return String.format("$%.2f", high);
    }

    public String getLow() {
        return String.format("$%.2f", low);
    }
}
