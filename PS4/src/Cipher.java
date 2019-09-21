public class Cipher {
    private String plainText;
    private String cipherText = "";
    private int key;

    public Cipher(String text, int key) throws UselessKeyException, EmptyPlainText {
        this.key = key;
        if (key % 26 == 0){
            throw new UselessKeyException(key);
        } else if (text.length() == 0){
            throw new EmptyPlainText();
        } else {
            while (key > 26){
                key -= 26;
            }
            plainText = text;
            for (int i = 0; i < plainText.length(); i++){
                char currentChar = plainText.charAt(i);
                // if char is a capital letter and if the key would make it not a capital letter anymore
                if (Character.isLetter(currentChar) && (int)currentChar < 91 && (int)currentChar + key > 90){
                    currentChar = (char)((((int)currentChar + key) % 90) + 64);
                // if char is a lowercase letter and if the key would make it not a lowercase letter anymore
                } else if (Character.isLetter(currentChar) && (int)currentChar < 123 && (int)currentChar + key > 122){
                    currentChar = (char)((((int)currentChar + key) % 122) + 96);
                } else {
                    currentChar = (char)((int)currentChar + key);
                }
                cipherText += currentChar;
            }
        }
    }

    public String getPlainText() {
        return plainText;
    }

    public String getCipherText(){
        return cipherText;
    }

    public int getKey(){
        return key;
    }
}
