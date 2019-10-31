import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarMakersYears {
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
            Scanner scanner = new Scanner(new File("car-list.txt"));
            scanner.nextLine();
            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                list.add(newLine.split("\t", 4));
            }
            // quickSort(list);

            Scanner keyboard = new Scanner(System.in);
            System.out.println("What car make are you looking for?");
            String make = keyboard.nextLine();

            String oldestYear = "3000", newestYear = "0";
            int oldestPos = 0, newestPos = 0;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i)[0].equals(make) && list.get(i)[2].compareToIgnoreCase(oldestYear) < 0) {
                    oldestPos = i;
                    oldestYear = list.get(i)[2];
                } else if (list.get(i)[0].equals(make) && list.get(i)[2].equalsIgnoreCase(oldestYear) && list.get(i)[3].compareToIgnoreCase(list.get(oldestPos)[3]) < 0) {
                    oldestPos = i;
                    oldestYear = list.get(i)[2];
                }
                if (list.get(i)[0].equals(make) && list.get(i)[2].compareToIgnoreCase(newestYear) > 0) {
                    newestPos = i;
                    newestYear = list.get(i)[2];
                } else if (list.get(i)[0].equals(make) && list.get(i)[2].equalsIgnoreCase(newestYear) && list.get(i)[3].compareToIgnoreCase(list.get(newestPos)[3]) > 0) {
                    newestPos = i;
                    newestYear = list.get(i)[2];
                }
            }

            System.out.println("Oldest " + make);
            System.out.printf("%15s%25s%5s%18s\n", list.get(oldestPos)[0], list.get(oldestPos)[1], list.get(oldestPos)[2], list.get(oldestPos)[3]);
            System.out.println("Newest " + make);
            System.out.printf("%15s%25s%5s%18s\n", list.get(newestPos)[0], list.get(newestPos)[1], list.get(newestPos)[2], list.get(newestPos)[3]);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
