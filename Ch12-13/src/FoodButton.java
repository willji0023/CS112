import javax.swing.*;

public class FoodButton extends JButton {
    private double price;

    public FoodButton(String label, double p){
        super(label);
        price = p;
    }

    public double getPrice() {
        return price;
    }
}
