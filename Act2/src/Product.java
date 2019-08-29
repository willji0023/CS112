public class Product extends Offering {

    double price = 0;

    public Product(String name, double price){
        super(name);
        this.price = price;
    }

    @Override
    public double getTotalCost() {
        return price;
    }
}
