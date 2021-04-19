package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size;
    private Node<T> topNode;

    private static class Node<T> {
        private T value;
        private Node<T> prevNode;

        public Node(T value) {
            this.value = value;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (topNode != null) {
            newNode.prevNode = topNode;
        }
        topNode = newNode;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return topNode.value;
    }

    public T pop() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        T tempvalue = topNode.value;
        topNode = topNode.prevNode;
        size--;
        return tempvalue;
    }

    public int size() {
        return size;
    }
}
