import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TicTacToeButton extends JButton {
    ImageIcon x = new ImageIcon("x.png");
    ImageIcon o = new ImageIcon("o.png");
    public String text;
    public TicTacToeButton() {
        super("");
        setBackground(new Color(102, 51, 0));
        setBorder(new LineBorder(new Color(250, 218, 51), 5));
    }
    public void markX() {
        setIcon(x);
        text = "x";
    }
    public void markO(){
        setIcon(o);
        text = "o";
    }
    public void reset(){
        setIcon(null);
        text = "";
    }
    public boolean marked(){
        return text == "x" || text == "o";
    }
}
