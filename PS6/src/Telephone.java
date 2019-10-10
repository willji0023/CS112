import java.util.ArrayList;

public class Telephone {
    private String number;

    public Telephone(String number) {
        this.number = number;
    }

    public void getPossibilities(ArrayList<String> list, String word, int iterator) {
        if (iterator < number.length()) {
            if (number.charAt(iterator) == '2') {
                getPossibilities(list, word + "A", iterator + 1);
                getPossibilities(list, word + "B", iterator + 1);
                getPossibilities(list, word + "C", iterator + 1);
            } else if (number.charAt(iterator) == '3') {
                getPossibilities(list, word + "D", iterator + 1);
                getPossibilities(list, word + "E", iterator + 1);
                getPossibilities(list, word + "F", iterator + 1);
            } else if (number.charAt(iterator) == '4') {
                getPossibilities(list, word + "G", iterator + 1);
                getPossibilities(list, word + "H", iterator + 1);
                getPossibilities(list, word + "I", iterator + 1);
            } else if (number.charAt(iterator) == '5') {
                getPossibilities(list, word + "J", iterator + 1);
                getPossibilities(list, word + "K", iterator + 1);
                getPossibilities(list, word + "L", iterator + 1);
            } else if (number.charAt(iterator) == '6') {
                getPossibilities(list, word + "M", iterator + 1);
                getPossibilities(list, word + "N", iterator + 1);
                getPossibilities(list, word + "O", iterator + 1);
            } else if (number.charAt(iterator) == '7') {
                getPossibilities(list, word + "P", iterator + 1);
                getPossibilities(list, word + "Q", iterator + 1);
                getPossibilities(list, word + "R", iterator + 1);
                getPossibilities(list, word + "S", iterator + 1);
            } else if (number.charAt(iterator) == '8') {
                getPossibilities(list, word + "T", iterator + 1);
                getPossibilities(list, word + "U", iterator + 1);
                getPossibilities(list, word + "V", iterator + 1);
            } else if (number.charAt(iterator) == '9') {
                getPossibilities(list, word + "W", iterator + 1);
                getPossibilities(list, word + "X", iterator + 1);
                getPossibilities(list, word + "Y", iterator + 1);
                getPossibilities(list, word + "Z", iterator + 1);
            } else {
                getPossibilities(list, word + number.charAt(iterator), iterator + 1);
            }
        } else {
            list.add(word);
        }
    }

    public ArrayList<String> getPossibilities() {
        ArrayList<String> list = new ArrayList<String>();
        getPossibilities(list, "", 0);
        return list;
    }
}
