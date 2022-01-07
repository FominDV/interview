package ru.fomin.linked;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public int getSize() {
        return size;
    }

    public void addFirst(T e) {
        Node<T> tempNode = first;
        Node<T> newNode = new Node<>(e, tempNode, null);
        first = newNode;
        if (tempNode == null) {
            last = newNode;
        } else {
            tempNode.previous = newNode;
        }
        size++;
    }

    public void addLast(T e) {
        Node<T> tempNode = last;
        Node<T> newNode = new Node<>(e, null, tempNode);
        last = newNode;
        if (tempNode == null) {
            first = newNode;
        } else {
            tempNode.next = newNode;
        }
        size++;
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.value;
    }

    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.value;
    }

    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<T> tempNode = first.next;
        T value = first.value;
        if (tempNode != null) {
            tempNode.previous = null;
            first = tempNode;
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        T value = last.value;
        Node<T> tempNode = last.previous;
        if (tempNode != null) {
            tempNode.next = null;
            last = tempNode;
        } else {
            first = null;
        }
        size--;
        return value;
    }

    public T get(int index) {
        return getNodeByIndex(index).value;
    }

    public T remove(int index) {
        Node<T> removingNode = getNodeByIndex(index);
        if (removingNode == last) {
            return removeLast();
        }
        if (removingNode == first) {
            return removeFirst();
        }
        removingNode.previous.next = removingNode.next;
        removingNode.next.previous = removingNode.previous;
        size--;
        return removingNode.value;
    }

    public void add(int index, T element) {
        if(index==0){
            addFirst(element);
            return;
        }
        Node<T> nextNode = getNodeByIndex(index);
        Node<T> newNode = new Node<>(element, nextNode, nextNode.previous);
        Node<T> previousNode = newNode.previous;
        nextNode.previous = newNode;
        previousNode.next = newNode;
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        if (size - 1 < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> tempNode;
        if (size / 2 > index + 1) {
            tempNode = first;
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.next;
            }
        } else {
            tempNode = last;
            for (int i = size - 1; i > index; i--) {
                tempNode = tempNode.previous;
            }
        }
        return tempNode;
    }

    @Override
    public String toString() {
        Node<T> next = first;
        StringBuilder stringBuilder = new StringBuilder("[");
        if (next != null) {
            stringBuilder.append(next.value);
            while (next.next != null) {
                stringBuilder.append(",");
                next = next.next;
                stringBuilder.append(next.value);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

}
