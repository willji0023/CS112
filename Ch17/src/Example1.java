import java.util.ArrayList;

public class Example1 {
    public static int numSwaps;
    public static int numIterations;

    public static void swap(ArrayList<String> data, int p1, int p2){
        String temp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, temp);
        numSwaps++;
    }

    public static void bubbleSort(ArrayList<String> data) {
        numSwaps = 0;
        numIterations = 0;
        for (int wall = data.size() - 1; wall >= 1; wall--) {
            for (int index = 0; index <= wall - 1; index++) {
                if (data.get(index).compareToIgnoreCase(data.get(index + 1)) > 0) {
                    swap(data, index, index + 1);
                }
                numIterations++;
            }
        }
    }
}
