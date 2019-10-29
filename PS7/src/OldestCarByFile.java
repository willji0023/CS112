import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OldestCarByFile {
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
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter filename");
        String filename = keyboard.nextLine();
        try {
            ArrayList<String[]> list = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            scanner.nextLine();
            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                list.add(newLine.split("\t", 3));
            }
            quickSort(list);

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i)[0].equalsIgnoreCase(list.get(i + 1)[0]) && list.get(i)[2].compareTo(list.get(i + 1)[2]) > 0) {
                    list.remove(i);
                    i--;
                } else if (list.get(i)[0].equalsIgnoreCase(list.get(i + 1)[0]) && list.get(i)[2].compareTo(list.get(i + 1)[2]) <= 0) {
                    list.remove(i + 1);
                    i--;
                }
            }

            System.out.println("Oldest cars by make");
            for (String[] car : list) {
                System.out.printf("%15s%25s%5s\n", car[0], car[1], car[2]);
            }
            System.out.println(list.size() + " result(s)");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
