package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        if (t == null)
            throw new NullPointerException();

        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null)
            throw new NullPointerException();

        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.data;
        head = head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;

        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = tail.data;
        tail = tail.prev;

        if (tail == null)
            head = null;
        else
            tail.next = null;

        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty())
            throw new IllegalStateException();

        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty())
            throw new IllegalStateException();

        return tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if (element == null)
            throw new NullPointerException();

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<T> oldValue = current;
        current.data = (T) element;

        return oldValue.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean add(Object o) {
        if (o == null)
            throw new NullPointerException();

        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new NullPointerException();

        Node<T> current = head;
        for (int i = 0; i < size; i++){
            if (current.equals(o)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();

        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}