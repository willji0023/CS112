import java.util.ArrayList;

public class MyList<T extends Number> {
    private ArrayList<T> numbers = new ArrayList<>();

    public void add(T element) { numbers.add(element); }

    public T getGreatest() {
        T result = numbers.get(0);
        for (T t : numbers) {
            /*
             * relational and mathematical operators don't work on objects
             * i.e. < > * / +
             */
            if (t.doubleValue() > result.doubleValue()) {
                result = t;
            }
        }
        return result;
    }
}
