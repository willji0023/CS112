import java.util.AbstractList;

public class MyArrayList<T> extends AbstractList<T> {
    @SuppressWarnings("unchecked")
    private T[] data = (T[])new Object[3];
    private int nextOpenSpace = 0; // count/size/length variable

    @Override
    public T get(int i) {
        return data[i];
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] biggerArray = (T[])new Object[data.length * 2]; // Make a bigger array
        for (int i = 0; i < data.length; i++)
            biggerArray[i] = data[i]; // copy all old stuff
        data = biggerArray; // make it so biggerArray becomes data
    }

    public boolean add(T element) {
        if (nextOpenSpace == data.length) // if not enough space
            resize();
        data[nextOpenSpace] = element; // insert at end
        nextOpenSpace++; // keep track
        return true; // list was modified
    }

    @Override
    public int size() {
        return nextOpenSpace;
    }
}
