import java.io.*;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args){
        System.out.println("Enter a filename");
        Scanner keyboard = new Scanner(System.in);
        String filename = keyboard.nextLine();
        try {
            FileInputStream ifstream = new FileInputStream(filename);
            DataInputStream inputFile = new DataInputStream(ifstream);
            boolean eof = false;
            int max = 0, min = 100000, count = 0;
            while(!eof){
                try {
                    int nextByte = inputFile.readInt();
                    if (nextByte > max){
                        max = nextByte;
                    }
                    if (nextByte < min){
                        min = nextByte;
                    }
                    count++;
                } catch (IOException e){
                    eof = true;
                }
            }
            System.out.println("Found " + count + " integers.");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
