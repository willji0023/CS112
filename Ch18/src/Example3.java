import java.util.ArrayList;
import java.util.List;

public class Example3 {
  public static void main(String[] args) {
    ArrayList<String> data1 = new ArrayList<>(List.of("Carl", "Fred", "Bob", "Amanda", "Vince"));
    ArrayList<Integer> data2 = new ArrayList<>(List.of(50, 30, 60, 80, 90));
    GenericSort.selectionSort(data1);
    GenericSort.selectionSort(data2);

    for (String current : data1)
      System.out.println(current);

    for (Integer current : data2)
      System.out.println(current);
  }

}
