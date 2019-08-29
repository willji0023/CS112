import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileStats {
    private String filename;

    public FileStats(String fname){
        filename = fname;
    }

    public int getNumMatchingWords(String wordToFind) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.toLowerCase().contains(wordToFind.toLowerCase()) ) {
                count++;
            }
        }
        return count;
    }

    public int getNumLines()  throws FileNotFoundException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()){
            scanner.nextLine();
            lines++;
        }
        return lines;
    }

    public String getFileName(){
        return filename;
    }
}