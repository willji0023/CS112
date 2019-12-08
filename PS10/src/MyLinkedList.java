import java.util.AbstractList;
import java.util.Random;

public class MyLinkedList<E extends Comparable<E>> extends AbstractList<E>
{
    private Node<E> last;
    private Node<E> first;
    private int size;

    public String toString() {
        // efficient way to concatenate many strings together
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (size() <= 0) {
            result.append(" ");
        } else {
            Node<E> ref = first;
            result.append(ref.value);
            while (ref.next != null) {
                ref = ref.next;
                result.append(", ").append(ref.value);
            }
        }
        result.append("]");
        return result.toString();
    }

    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        Node<E> ref = first;
        for (int x = 0; x < index; x++)
            ref = ref.next;
        return ref.value;
    }

    // SUPER FAST: O(1) constant time, the best you can get
    public boolean add(E value) {
        if (isEmpty())
            first = last = new Node<>(value);
        else {
            last.next = new Node<>(value);
            last = last.next; // leap frog!
        }
        size++;
        return false;
    }

    // O(N) for worst case
    public void add(int index, E value) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0)
            first = new Node<E>(value, first);
        else {
            Node<E> ref = first;
            // travel to the node right before index
            for (int x = 0; x < index - 1; x++)
                ref = ref.next;
            // make the connection
            ref.next = new Node<>(value, ref.next);
        }

        if (last.next != null)
            last = last.next;
        size++;
    }

    public E remove(int index) {
        E removed = null;
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0) {
            removed = first.value;
            first = first.next; // garbage collect the old "first"
            if (first == null)
                last = null; // now list is empty
        } else {
            Node<E> ref = first;
            // travel to the node right before index
            for (int x = 0; x < index - 1; x++)
                ref = ref.next;
            // since ref points the one before index,
            removed = ref.next.value;
            ref.next = ref.next.next; // this will replace the index with the one after it
            if (ref.next == null)
                last = ref;
        }
        size--;
        return removed;
    }

    public int find(E value) {
        Node<E> current = first;
        int index = 0;
        while (!current.value.equals(value)) {
            current = current.next;
            index++;
        }
        return index;
    }

    public boolean isEmpty() { return first == null; }

    public int size() {
        return size;
    }

    public E set(int index, E value) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        Node<E> ref = first;
        // travel to the node at the index
        for (int x = 0; x < index; x++)
            ref = ref.next;
        ref.value = value; // this will replace the value of target node
        return value;
    }

    private void swap (int index1, int index2) {
        Node<E> ref1 = first;
        Node<E> ref2 = first;
        for (int x = 0; x < index1; x++)
            ref1 = ref1.next;
        for (int x = 0; x < index2; x++)
            ref2 = ref2.next;
        E temp = ref1.value;
        ref1.value = ref2.value;
        ref2.value = temp;
    }

    public void shuffle(long seed) {
        Random rng = new Random(seed);
        int count = 0;
        while (count < size()) {
            swap(count, rng.nextInt(size()));
            count++;
        }
    }

    public void sort() {
        for (int wall = size() - 1; wall >= 1; wall--) {
            Node<E> current = first;
            for (int i = 0; i <= wall - 1; i++) {
                if (current.value.compareTo(current.next.value) > 0)
                    swap(i, i+1);
                current = current.next;
            }
        }
    }

    public void reverse() {
        for (int i = 0; i < (size()/2); i++) {
            swap(i, size() - 1 - i);
        }
    }

    public E removeMinimum() {
        if (size() == 0)
            return null;
        else {
            Node<E> current = first;
            E minimum = first.value;
            int index = 0;
            for (int i = 0; current != null; i++) {
                if (current.value.compareTo(minimum) < 0) {
                    minimum = current.value;
                    index = i;
                }
                current = current.next;
            }
            remove(index);
            return minimum;
        }
    }

    public void removeDuplicates() {
        Node<E> valueToSearch = first;
        while (valueToSearch != null) {
            Node<E> current = valueToSearch;
            for (int i = 1; i < size() - 1; i++) {
                current = current.next;
                if (current == null)
                    break;
                if (current.value.equals(valueToSearch.value)) {
                    remove(i + find(valueToSearch.value));
                    i--;
                }
            }
            valueToSearch = valueToSearch.next;
        }
    }
}
