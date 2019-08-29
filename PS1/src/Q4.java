import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a filename");
        Scanner keyboard = new Scanner(System.in);
        FileStats fs = new FileStats(keyboard.nextLine());
        System.out.println(fs.getFileName() + " has " + fs.getNumLines() + " lines");
        System.out.println("Enter some text");
        String word = keyboard.nextLine();
        System.out.println(fs.getNumMatchingWords(word) + " line(s) contain \"" + word + "\"");

    }
}
