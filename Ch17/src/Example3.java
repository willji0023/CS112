import java.util.ArrayList;

public class Example3 {
    public static int numSwaps;
    public static int numIterations;

    public static void insertionSort(ArrayList<String> data) {
        for (int i = 1; i < data.size(); i++) {
            numIterations++;
            String selected = data.get(i);
            int scan = i; // scan moves down, i moves up
            // this loops moves down and tries to find numbers BIGGER than selected
            while (scan > 0 && data.get(scan-1).compareToIgnoreCase(selected) > 0) {
                numSwaps++;
                data.set(scan, data.get(scan-1));
                scan--;
            }
            data.set(scan, selected);
            numSwaps++;
        }
    }
}
