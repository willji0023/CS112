import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example6 extends JFrame {
    public Example6() {
        super.setTitle("File Chooser");
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    private void buildPanel() {
        // Northern Region
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("Exit");
        menu.add(item);
        bar.add(menu);
        super.add(bar, BorderLayout.NORTH);

        // Northern Region Functionality
        item.addActionListener(event -> {
            System.exit(0);
        });

        // Center Region
        JTextArea area = new JTextArea();
        JScrollPane scroller = new JScrollPane(area);
        super.add(scroller, BorderLayout.CENTER);

        // Southern Region
        JButton open = new JButton("Open");
        JPanel openPanel = new JPanel();
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 40);
        open.setFont(font);
        openPanel.add(open);
        super.add(openPanel, BorderLayout.SOUTH);

        // Southern Region Functionality
        open.addActionListener(event -> {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(this);
            if (status == JFileChooser.APPROVE_OPTION){
                File selectedFile = chooser.getSelectedFile();
                try {
                    Scanner inputFile = new Scanner(selectedFile);
                    while (inputFile.hasNextLine()){
                        String line = inputFile.nextLine();
                        area.append(line + "\n");
                    }
                    inputFile.close();
                } catch (FileNotFoundException e) {
                    area.setText(e.getMessage());
                }
            }
        });
    }

    public static void main(String[] args){
        new Example6();
    }
}
