package com.company;

public class Main {
    private int[] array;
    private int size;
    private int capacity;

    public Main(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(int element) {
        if (size == capacity) {
            resize();
        }
        array[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Main arr = new Main(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println("Element at index 3: " + arr.get(3)); // Output: 4

        arr.set(1, 10);
        System.out.println("Element at index 1: " + arr.get(1)); // Output: 10

        arr.remove(2);
        System.out.println("Size after removal: " + arr.size()); // Output: 4
    }
}