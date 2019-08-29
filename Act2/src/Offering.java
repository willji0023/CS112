public abstract class Offering
{
    private String name;

    public Offering(String n) {
        name = n;
    }

    public abstract double getTotalCost();

    public String toString() {
        return name + " costs $" + String.format("%.2f", getTotalCost());
    }
}
