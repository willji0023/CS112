import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Example4 extends JFrame {
    public Example4() {
        super.setTitle("Layout Manager Test");
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
        buildPanel();
    }

    private void buildPanel() {
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        super.setLayout(new GridLayout(3,2));
        super.add(b1);
        super.add(b2);
        super.add(b3);
        super.add(b4);
        super.add(b5);

        ActionListener callback = event -> {
            System.out.println(event.getActionCommand());
        };
        b1.addActionListener(callback);
        b2.addActionListener(callback);
        b3.addActionListener(callback);
        b4.addActionListener(callback);
        b5.addActionListener(callback);
    }

    public static void main(String[] args){
        new Example4();
    }
}
