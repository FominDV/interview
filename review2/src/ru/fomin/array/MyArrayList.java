package ru.fomin.array;

public class MyArrayList<T> {

    private int size;
    private int capacity;
    private Object[] array;

    public MyArrayList() {
        capacity = 10;
        array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (array[0] != null) {
            stringBuilder.append(array[0]);
            for (int i = 1; i < size; i++) {
                stringBuilder.append(",");
                stringBuilder.append(array[i]);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean add(T element) {
        verifyCapacity();
        array[size++] = element;
        return true;
    }

    public void add(int index, T element) {
        verifyIndex(index);
        verifyCapacity();
        for (int i = size; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public T get(int index) {
        verifyIndex(index);
        return (T) array[index];
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public void set(int index, T element) {
        verifyIndex(index);
        array[index] = element;
    }

    public T remove(int index) {
        T element = get(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    public boolean remove(T element) {
        if (!contains(element)) {
            return false;
        }
        remove(indexOf(element));
        return true;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (((T) array[i]).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void verifyIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void verifyCapacity() {
        if (size == capacity) {
            Object[] newArray = new Object[capacity = (int) (capacity * 1.5)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

}
