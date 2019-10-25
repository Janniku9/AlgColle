package dataStructures;

public class Stack<T> {
    public int length = 0;
    Node<T> top;

    public Stack () {

    }

    public boolean isEmpty () {
        return (length == 0) ? true:false;
    }

    public void push (Node<T> x) {
        if (length == 0) {
            top = x;
            length++;
        } else {
            top.next = x;
            x.previous = top;
            top = x;
            length++;
        }
    }

    public void push (T x) {
        if (length == 0) {
            top = new Node<T>(x);
            length++;
        } else {
            Node<T> node =  new Node<T>(x);
            top.next = node;
            node.previous = top;
            top = node;
            length++;
        }
    }

    public T pop () {
        T res = null;
        if (length == 1) {
            res =  top.value;
            top = null;
            length--;
        }else if (length > 1){
            res = top.value;
            top = top.previous;
            top.next = null;
            length--;
        }

        return res;
    }

    public T top () {
        if (top != null)
            return top.value;
        else return null;
    }
}
