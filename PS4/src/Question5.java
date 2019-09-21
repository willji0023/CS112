import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Question5 {
    private static boolean valid;
    private static int sum;
    private static String card;

    public static void validate(long cardNum){
        card = Long.toString(cardNum);
        boolean secondRound = false;
        for (int i = card.length() - 1; i >= 0; i--){
            int num = Character.getNumericValue(card.charAt(i));
            if (secondRound){
                num *= 2;
                if (num > 9){
                    num -= 9;
                }
            }
            sum += num;
            secondRound = !secondRound;
        }
        if (sum % 10 == 0){
            valid = true;
        } else {
            valid = false;
        }
    }

    public static void main(String[] args){
        System.out.println("Enter a filename");
        Scanner keyboard = new Scanner(System.in);
        String filename = keyboard.nextLine();
        try {
            FileInputStream ifstream = new FileInputStream(filename);
            DataInputStream inputFile = new DataInputStream(ifstream);
            boolean eof = false;
            while (!eof){
                try {
                    long nextLong = inputFile.readLong();
                    validate(nextLong);
                    System.out.print("Credit card number:");
                    for (int i = 0; i < card.length(); i++){
                        if (i % 4 == 0){
                            System.out.print(" ");
                        }
                        System.out.print(card.charAt(i));
                    }
                    System.out.println("\nChecksum: " + sum);
                    if (valid){
                        System.out.println("Card status: VALID");
                    } else {
                        System.out.println("Card status: INVALID");
                    }
                    sum = 0;
                } catch (IOException e){
                    eof = true;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
