public class MyLinkedList<T> {
    private Node<T> last;
    private Node<T> first;
    private int size;

    // O(N)
    public String toString() {
        // efficient way to concatenate many strings together
        StringBuilder result = new StringBuilder();
        Node ref = first;
        while (ref != null) {
            result.append(ref.value).append("\n");
            ref = ref.next;
        }
        return result.toString();
    }

    public void printInReverse(){
        printInReverse(first);
    }

    private void printInReverse(Node ref) {
        if (ref != null) {
            printInReverse(ref.next);
            System.out.println(ref.value);
        }
    }

    // O(N) this is slow compared to ArrayList
    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        Node<T> ref = first;
        for (int x = 0; x < index; x++)
            ref = ref.next;
        return (T) ref.value;
    }

    // SUPER FAST: O(1) constant time, the best you can get
    public void add(T value) {
        if (isEmpty())
            first = last = new Node<>(value);
        else {
            last.next = new Node<>(value);
            last = last.next; // leap frog!
        }
        size++;
    }

    // O(N) for worst case
    public void add(int index, T value) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0)
            first = new Node<T>(value, first);
        else {
            Node ref = first;
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

    // O(N)
    public void remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0) {
            first = first.next; // garbage collect the old "first"
            if (first == null)
                last = null; // now list is empty
        } else {
            Node ref = first;
            // travel to the node right before index
            for (int x = 0; x < index - 1; x++)
                ref = ref.next;
            // since ref points the one before index,
            ref.next = ref.next.next; // this will replace the index with the one after it
            if (ref.next == null)
                last = ref;
        }
        size--;
    }

    public boolean isEmpty() { return first == null; }

    public int size() {
        return size;
    }
}
