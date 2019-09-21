import javax.swing.*;

public class Demo extends JFrame {
    private String firstName = "", lastName = "";

    public Demo(){
        super.setTitle("Star Wars Name Generator");
        super.setSize(400, 300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    private void buildPanel(){
        JLabel topText = new JLabel("Enter your first name");
        JTextField topField = new JTextField(35);
        JLabel bottomText = new JLabel("Enter your last name");
        JTextField bottomField = new JTextField(35);
        JButton button = new JButton("Generate Name!");
        JPanel panel = new JPanel();

        button.addActionListener(event -> {
                if (topField.getText().length() < 3){
                    JOptionPane.showMessageDialog(this,  "first name is too short");
                } else if (bottomField.getText().length() < 2){
                    JOptionPane.showMessageDialog(this, "last name is too short");
                } else {
                    String firstName = topField.getText().substring(0, 3);
                    String lastName = bottomField.getText().substring(0, 2);
                    JOptionPane.showMessageDialog(this, firstName + "-" + lastName);
            }
        });

        panel.add(topText);
        panel.add(topField);
        panel.add(bottomText);
        panel.add(bottomField);
        panel.add(button);

        super.add(panel);
    }

    public static void main(String args []){
        new Demo();
    }
}
