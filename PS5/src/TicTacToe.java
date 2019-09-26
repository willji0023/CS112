import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private boolean xturn = true;
    private TicTacToeButton[] buttons = new TicTacToeButton[9];

    public TicTacToe() {
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new TicTacToeButton();
        }
        super.setTitle("Tic Tac Toe");
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    public boolean hasWon() {
        // Top Row
        if (buttons[0].text == buttons[1].text && buttons[0].text == buttons[2].text && buttons[0].marked()){ // Top Row
            return true;
        } else if (buttons[3].text == buttons[4].text && buttons[3].text == buttons[5].text  && buttons[3].marked()){ // Middle Row
            return true;
        } else if (buttons[6].text == buttons[7].text && buttons[6].text == buttons[8].text  && buttons[6].marked()){ // Bottom Row
            return true;
        } else if (buttons[0].text == buttons[3].text && buttons[0].text == buttons[6].text  && buttons[0].marked()){ // Left Column
            return true;
        } else if (buttons[1].text == buttons[4].text && buttons[1].text == buttons[7].text  && buttons[1].marked()){ // Middle Column
            return true;
        } else if (buttons[2].text == buttons[5].text && buttons[2].text == buttons[8].text  && buttons[2].marked()) { // Right Column
            return true;
        } else if (buttons[0].text == buttons[4].text && buttons[0].text == buttons[8].text && buttons[0].marked()){
            return true;
        } else if (buttons[2].text == buttons[4].text && buttons[2].text == buttons[6].text && buttons[2].marked()){
            return true;
        } else {
            return false;
        }
    }

    public boolean hasCatsGame() {
        boolean allMarked = true;
        for (TicTacToeButton i : buttons){
            if (!i.marked()){
                allMarked = false;
            }
        }
        return allMarked;
    }

    public void newGame() {
        for (TicTacToeButton i : buttons){
            i.reset();
        }
    }

    public void buildPanel(){
        super.setLayout(new GridLayout(3,3));
        for(TicTacToeButton i : buttons){
            super.add(i);
        }

        ActionListener buttonClick = event -> {
            TicTacToeButton button = (TicTacToeButton)event.getSource();
            if (xturn){
                if (!button.marked()){
                    button.markX();
                    if (hasWon()){
                        JOptionPane.showMessageDialog(this, "X has won! Resetting...");
                        newGame();
                    } else if (hasCatsGame()){
                        JOptionPane.showMessageDialog(this, "Cats Game! Resetting...");
                        newGame();
                    }
                    xturn = !xturn;
                }

            } else {
                if (!button.marked()){
                    button.markO();
                    if (hasWon()){
                        JOptionPane.showMessageDialog(this, "O has won! Resetting...");
                        newGame();
                    } else if (hasCatsGame()){
                        JOptionPane.showMessageDialog(this, "Cats Game! Resetting...");
                        newGame();
                    }
                    xturn = !xturn;
                }
            }
        };

        for (TicTacToeButton i : buttons){
            i.addActionListener(buttonClick);
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
