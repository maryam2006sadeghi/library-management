package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (element == null)
            throw new NullPointerException();

        T oldElement = (T) elements[index];
        elements[index] = element;

        return oldElement;
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

        ensureCapacity();
        elements[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();

        int index = -1;
        for (int i = 0; i < size; i++){
            if (elements[i].equals(o)){
                index = i;
                break;
            }
        }

        if (index == -1)
            return false;

        for (int i = index; i < size - 1; i++)
            elements[i] = elements[i + 1];

        elements[size - 1] = null;
        size--;

        return true;
    }
}