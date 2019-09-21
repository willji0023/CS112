import javax.swing.*;

public class Example2 extends JFrame {
    public Example2() {
        super.setTitle("Converter");
        super.setSize(400, 300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    private void buildPanel(){
        JLabel text = new JLabel("Enter distance in kilometers");
        JTextField data = new JTextField(30);
        JButton convert = new JButton("Convert");

        JPanel subwindow = new JPanel();
        subwindow.add(text);
        subwindow.add(data);
        subwindow.add(convert);

        convert.addActionListener(event -> {
            String dataFromField = data.getText();
            double kilometers = Double.parseDouble(dataFromField);
            double miles = kilometers / 1.609;
            JOptionPane.showMessageDialog(this, "Miles: " + miles);
        });

        super.add(subwindow);
    }

    public static void main(String[] args) {
        Example2 test = new Example2();
    }
}
