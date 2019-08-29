public class Service extends Offering {

    private String name;
    private double hours = 0;
    private double hourlyPrice = 0;

    public Service(String name, double hourlyPrice, double hours){
        super(name);
        this.name = name;
        this.hours = hours;
        this.hourlyPrice = hourlyPrice;
    }

    @Override
    public double getTotalCost() {
        return hours * hourlyPrice;
    }

    @Override
    public String toString() {
        return this.name + " costs $" + String.format("%.2f", getTotalCost()) + ". Each hour costs " + String.format("%.2f", hourlyPrice);
    }
}
