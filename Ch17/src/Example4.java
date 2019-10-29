import java.util.ArrayList;

public class Example4 {
    public static void quickSort(ArrayList<String> data) {
        quickSort(data, 0, data.size() - 1);
    }
    private static void quickSort(ArrayList<String> data, int start, int end) {
        if (start < end) { // if we have more than one element
            int pivotIndex = partition(data, start, end);
            quickSort(data, start, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, end);
        }
    }
    private static int partition(ArrayList<String> data, int start, int end) {
        int mid = (start + end) / 2; // truncation is okay here
        String pivotValue = data.get(mid);
        Example1.swap(data, start, mid);
        int endOfSmallElements = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i).compareToIgnoreCase(pivotValue) <= 0) {
                endOfSmallElements++;
                Example1.swap(data, i, endOfSmallElements); // move small to the left, leave big elements untouched
            }
        }

        Example1.swap(data, start, endOfSmallElements); // bring pivot value back to end of small elements
        return endOfSmallElements;
    }


}
