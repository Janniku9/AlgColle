package AlgsFromScript;

public class Queue<T> {
    int length = 0;
    Node<T> first, last;

    public Queue () {

    }

    public void enqueue (T value) {
        Node<T> node = new Node<T>(value);
        if (length != 0) {
            last.previous = node;
            node.next = last;
            last = node;
            length++;
        } else {
            first = node;
            last = node;
            first.previous = node;
            last.next = node;
            length++;
        }
    }

    public T dequeue () {
        T res = null;
        if (length > 1) {
            res = first.value;
            first = first.previous;
            first.next = null;
            length--;
        } else if (length == 1) {
            res = first.value;
            first = null;
            last = null;
            length--;
        }

        return res;
    }

    public T front () {
        if (first != null)
            return first.value;
        else return null;
    }

    public boolean isEmpty () {
        return (length == 0) ? true:false;
    }
}
