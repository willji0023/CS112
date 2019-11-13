import java.util.ArrayList;

public class ToolBox implements GenericTools {

    @Override
    public <T> void swap(ArrayList<T> data, int p1, int p2) {
        T temp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, temp);
    }

    @Override
    public <T extends Comparable<T>> void insertionSort(ArrayList<T> data) {
        insertionSort(data, 1, data.size());
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end) {
        for (int i = 1; i < data.size(); i++) {
            T selected = data.get(i);
            int j = i;
            while (j > 0 && data.get(j - 1).compareTo(selected) > 0) {
                data.set(j, data.get(j - 1));
                j--;
            }
            data.set(j, selected);
        }
        ArrayList<T> sublist = new ArrayList<T>();
        for (int i = start; i < end; i++) {
            sublist.add(data.get(i));
        }
        return sublist;
    }
}
