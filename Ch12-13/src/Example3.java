import javax.swing.*;
import java.awt.*;

public class Example3 extends JFrame {
    private int numClicks = 0;
    private boolean ascending = true;

    public Example3(){
        super.setTitle("Click counter");
        super.setSize(800, 600);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
    }

    private void buildPanel(){
        JButton click = new JButton("No clicks yet!");
        super.add(click);
        click.addActionListener(event -> {
            if (ascending){
                numClicks++;
            } else {
                numClicks--;
            }
            if (numClicks > 50){
                numClicks = 50;
                ascending = false;
                click.setBackground(Color.YELLOW);
                click.setForeground(Color.BLACK);
            } else if (numClicks < 0){
                numClicks = 0;
                ascending = true;
                click.setBackground(Color.CYAN);
                click.setForeground(Color.MAGENTA);
            }
            click.setText("Current count: " + numClicks);
        });
    }

    public static void main(String[] args){
        new Example3();
    }
}
