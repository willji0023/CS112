import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashCode {
    public static int getHash(String word) {
        HashMap<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a')
                characters.put(c, 100);
            else if (c == 'e')
                characters.put(c, 200);
            else if (c == 'i')
                characters.put(c, 300);
            else if (c == 'o')
                characters.put(c, 400);
            else if (c == 'u')
                characters.put(c, 500);
            else if (Character.isLetter(c))
                characters.put(c, Character.toString(c).hashCode() - 96);
            else
                characters.put(c, 0);
        }
        int hashcode = 0;
        for (int i = 1; i <= word.length(); i++) {
            if (characters.get(word.charAt(i-1)) <= 26)
                hashcode += i * characters.get(word.charAt(i - 1));
            else
                hashcode += characters.get(word.charAt(i-1));
        }
        return hashcode;
    }

    public static void hashAll(Set<String> data) {
        Map<Integer, String> words = new HashMap<>();
        for (String word : data) {
            if (words.getOrDefault(getHash(word.toLowerCase()), "Not Found") == "Not Found")
                words.put(getHash(word.toLowerCase()), word);
        }
        LinkedHashMap<Integer, String> sortedMap = words.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        for (int key: sortedMap.keySet()) {
            String value = sortedMap.get(key);
            System.out.println("Hash: " + key + " Word: " + value);
        }


    }
}