import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilePattern {
    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void load(Scanner inputFile) {
        while (inputFile.hasNext()) {
            numbers.add(inputFile.nextInt());
        }
    }

    public static void swap(ArrayList<Integer> data, int p1, int p2){
        int temp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, temp);
    }

    public static void quickSort(ArrayList<Integer> data) {
        quickSort(data, 0, data.size() - 1);
    }

    private static void quickSort(ArrayList<Integer> data, int start, int end) {
        if (start < end) { // if we have more than one element
            int pivotIndex = partition(data, start, end);
            quickSort(data, start, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, end);
        }
    }

    private static int partition(ArrayList<Integer> data, int start, int end) {
        int mid = (start + end) / 2; // truncation is okay here
        int pivotValue = data.get(mid);
        swap(data, start, mid);
        int endOfSmallElements = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i) < pivotValue) {
                endOfSmallElements++;
                swap(data, i, endOfSmallElements);
            }
        }

        swap(data, start, endOfSmallElements); // bring pivot value back to end of small elements
        return endOfSmallElements;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a filename");
        try {
            Scanner inputFile = new Scanner(new File(keyboard.nextLine()));
            load(inputFile);
            quickSort(numbers);
            int j = numbers.size();
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(numbers.get(i));
                System.out.println(numbers.get(j - 1));
                j--;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File no found");
        }
    }
}
