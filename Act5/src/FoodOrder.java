import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FoodOrder extends JFrame {
    private double orderPrice = 0;

    public FoodOrder() {
        super.setTitle("Ordering Console");
        super.setSize(400, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    private void buildPanel() {
        JTextArea area = new JTextArea();
        area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        JScrollPane scroller = new JScrollPane(area);
        scroller.setBorder((BorderFactory.createTitledBorder("Food Ordered")));;
        super.add(scroller, BorderLayout.CENTER);

        JPanel botPanel = new JPanel();
        JButton burger = new FoodButton("Burger $3", 3.00);
        JButton salad = new FoodButton("Salad $2", 2.00);
        JButton soda = new FoodButton("Soda $1", 1.00);
        botPanel.add(burger);
        botPanel.add(salad);
        botPanel.add(soda);
        super.add(botPanel, BorderLayout.SOUTH);

        ActionListener callback = event -> {
            FoodButton foodButton = (FoodButton)event.getSource();
            orderPrice += foodButton.getPrice();
            area.append(String.format("%-20s%10.2f\n", foodButton.getText().split(" ")[0], orderPrice));
        };
        burger.addActionListener(callback);
        salad.addActionListener(callback);
        soda.addActionListener(callback);
    }

    public static void main(String[] args){
        new FoodOrder();
    }
}
