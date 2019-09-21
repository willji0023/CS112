import javax.swing.*;

public class Example1 extends JFrame {
    public Example1() {
        super.setTitle("Basic Window");
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        Example1 test = new Example1();
    }
}
