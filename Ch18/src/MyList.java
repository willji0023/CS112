import java.util.ArrayList;

public class MyList<T extends Number> {
    private ArrayList<T> numbers = new ArrayList<>();

    public void add(T element) {
        numbers.add(element);
    }
}
