import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.temporal.JulianFields;

public class Example5 extends JFrame {
    public final double taxRate = 1.08;
    public Example5() {
        super.setTitle("Price Calculator");
        super.setSize(600, 400);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    public void buildPanel() {
        JPanel foodItems = new JPanel();
        foodItems.setLayout(new GridLayout(1,3));

        JButton pizza = new FoodButton("Pizza", 3.50);
        JButton salad = new FoodButton("Salad", 2.80);
        JButton soda = new FoodButton("Soda", 1.00);
        foodItems.add(pizza);
        foodItems.add(salad);
        foodItems.add(soda);

        super.add(foodItems);

        // set up the tax panel
        JPanel taxPanel = new JPanel();
        JRadioButton tax = new JRadioButton("Apply Tax", true);
        JRadioButton notax = new JRadioButton("No Tax");

        ButtonGroup me = new ButtonGroup();
        me.add(tax);
        me.add(notax);
        taxPanel.add(tax);
        taxPanel.add(notax);
            taxPanel.setBorder((BorderFactory.createTitledBorder("Tax Options")));

        super.add(taxPanel, BorderLayout.SOUTH);

        ActionListener callback = event -> {
            FoodButton whatWasClickedOn = (FoodButton)event.getSource();
            double totalCost;
            if (tax.isSelected()){
                totalCost = whatWasClickedOn.getPrice() * taxRate;
            } else {
                totalCost = whatWasClickedOn.getPrice();
            }
            String txt = String.format(whatWasClickedOn.getText() + " %.2f", totalCost);
            JOptionPane.showMessageDialog(this, txt);
        };

        // This is an alternate implementation of the above callback
        ActionListener alternate = event -> {
            if (event.getSource() == pizza){
                System.out.println("Pizza $3.00");
            } else if (event.getSource() == salad){
                System.out.println("Salad $2.00");
            } else if (event.getSource() == soda){
                System.out.println("Soda $1.00");
            }
        };
        pizza.addActionListener(callback);
        salad.addActionListener(callback);
        soda.addActionListener(callback);
    }
    public static void main (String[] args){
        new Example5();
    }
}
