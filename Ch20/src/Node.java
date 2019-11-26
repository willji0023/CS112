public class Node<T> {
    public T value;
    public Node next;

    public Node(T t, Node n) {
        value = t;
        next = n;
    }

    public Node(T t) {
        this(t, null);
    }
}
