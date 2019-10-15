import java.util.ArrayList;

public class Example2 {
    public static int numSwaps;
    public static int numIterations;

    public static void selectionSort(ArrayList<String> data) {
        for (int i = 0; i < data.size(); i++) {
            int indexOfSmallest = i; // assume first value is smallest
            for (int finder = i + 1; finder < data.size(); finder++) {
                if (data.get(finder).compareToIgnoreCase(data.get(indexOfSmallest)) < 0) {
                    indexOfSmallest = finder; // keep track of this new small value
                }
            }
            Example1.swap(data, i, indexOfSmallest);
            numSwaps++;
            numIterations++;
        }
    }
}
