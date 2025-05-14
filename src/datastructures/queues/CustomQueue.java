package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomQueue(int capacity) {
        list = new CustomLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean add(Object t) {
        if (list.size() >= capacity)
            throw new IllegalStateException();

        list.addLast((T) t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if (list.size() >= capacity)
            return false;

        else{
            list.addLast((T) t);
            return true;
        }
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;

        return list.removeFirst();
    }

    @Override
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return list.getFirst();
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;

        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}