import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarMakers {
    public static void swap(ArrayList<String[]> data, int p1, int p2){
        String[] temp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, temp);
    }

    public static void quickSort(ArrayList<String[]> data) {
        quickSort(data, 0, data.size() - 1);
    }

    private static void quickSort(ArrayList<String[]> data, int start, int end) {
        if (start < end) { // if we have more than one element
            int pivotIndex = partition(data, start, end);
            quickSort(data, start, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, end);
        }
    }

    private static int partition(ArrayList<String[]> data, int start, int end) {
        int mid = (start + end) / 2; // truncation is okay here
        String[] pivotValue = data.get(mid);
        swap(data, start, mid);
        int endOfSmallElements = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i)[0].compareToIgnoreCase(pivotValue[0]) < 0) {
                endOfSmallElements++;
                swap(data, i, endOfSmallElements);
            } else if (data.get(i)[0].compareToIgnoreCase(pivotValue[0]) == 0 && data.get(i)[1].compareToIgnoreCase(pivotValue[1]) < 0) {
                endOfSmallElements++;
                swap(data, i, endOfSmallElements);
            } else if (data.get(i)[0].compareToIgnoreCase(pivotValue[0]) == 0 && data.get(i)[1].compareToIgnoreCase(pivotValue[1]) == 0 && data.get(i)[2].compareToIgnoreCase(pivotValue[2]) < 0) {
                endOfSmallElements++;
                swap(data, i, endOfSmallElements);
            }
        }

        swap(data, start, endOfSmallElements); // bring pivot value back to end of small elements
        return endOfSmallElements;
    }

    public static void main(String[] args) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            Scanner scanner = new Scanner(new File("cars.txt"));
            scanner.nextLine();
            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                list.add(newLine.split("\t", 3));
            }
            quickSort(list);

            Scanner keyboard = new Scanner(System.in);
            System.out.println("What car make are you looking for?");
            String make = keyboard.nextLine();

            for (int i = 0; i < list.size(); i++){
                if (list.get(i)[0].equals(make))
                System.out.printf("%15s%25s%5s\n", list.get(i)[0], list.get(i)[1], list.get(i)[2]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
