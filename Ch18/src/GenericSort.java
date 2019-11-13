import java.util.ArrayList;

public class GenericSort {
  public static <T> void swap(ArrayList<T> data, int p1, int p2) {
    T element = data.get(p1);
    data.set(p1, data.get(p2));
    data.set(p2, element);
  }

  public static <T extends Comparable<T>> void selectionSort(ArrayList<T> data) {
    for (int index = 0; index < data.size() - 1; index++) {
      int smallest_index = index;
      for (int subscript = index + 1; subscript < data.size(); subscript++) {
        if (data.get(subscript).compareTo(data.get(smallest_index)) < 0) {
          swap(data, subscript, smallest_index);
        }
      }
    }
  }
}
