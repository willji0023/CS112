import java.io.*;
import java.util.Scanner;

public class Example3A {
    public static void applyCipher(String filename, int key, String resultingFileName) {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream inputFile = new DataInputStream(fstream);

            FileOutputStream ofstream = new FileOutputStream(resultingFileName);
            DataOutputStream outputFile = new DataOutputStream(ofstream);

            // Keep track of when we should keep going
            boolean eof = false;
            while(!eof){
                try {
                    // read an unfiltered byte
                    int number = inputFile.readUnsignedByte();
                    outputFile.writeByte(number+key);
                } catch (IOException e) {
                    eof = true; // We crashed. In the world of binary files, this means we're done
                }
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void decrypt(String filename, int key) {

    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("I will encrypt anything! Enter a filename");
        String filename = keyboard.nextLine();
        System.out.println("Enter key");
        int key = keyboard.nextInt();
        System.out.println("[1] Encrypt");
        System.out.println("[2] Decrypt");
        int operation = keyboard.nextInt();

        if (operation == 1){
            applyCipher(filename, key, "enc" + filename);
        } else if (operation == 2){
            applyCipher(filename, -key, "dec" + filename);
        } else {
            System.out.println("I dunno what to do.");
        }
    }
}
