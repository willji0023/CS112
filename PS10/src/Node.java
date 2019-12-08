public class Node<E> {
    public E value;
    public Node<E> next;

    public Node(E e, Node<E> n) {
        value = e;
        next = n;
    }

    public Node(E e) {
        this(e, null);
    }
}
