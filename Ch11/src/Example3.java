import java.util.Scanner;

public class Example3 {
    public static String encrypt(String plaintext, int key){
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++){
            char result = (char)((int)plaintext.charAt(i) + key);
            ciphertext += result;
        }
        return ciphertext;
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a secret message");
        String plaintext = keyboard.nextLine();
        System.out.println("Enter a key");
        int key = keyboard.nextInt();

        String ciphertext = encrypt(plaintext, key);
        System.out.println(ciphertext);
    }
}
