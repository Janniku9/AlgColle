package dataStructures;

public class Node<T> {
    T value;
    Node next, previous;

    public Node (T value) {
        this.value = value;
    }
}
