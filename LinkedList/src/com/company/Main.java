package com.company;
import java.util.NoSuchElementException;



        public class LinkedList<T> {
            private Node<T> head;
            private int size;

            private static class Node<T> {
                private T data;
                private Node<T> next;

                public Node(T data) {
                    this.data = data;
                }
            }

            public void addFirst(T item) {
                Node<T> newNode = new Node<>(item);
                newNode.next = head;
                head = newNode;
                size++;
            }

            public void addLast(T item) {
                Node<T> newNode = new Node<>(item);
                if (head == null) {
                    head = newNode;
                } else {
                    Node<T> current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
                size++;
            }

            public T removeFirst() {
                if (isEmpty()) {
                    throw new NoSuchElementException();
                }
                T data = head.data;
                head = head.next;
                size--;
                return data;
            }

            public boolean isEmpty() {
                return head == null;
            }

            public int size() {
                return size;
            }

            public static void main(String[] args) {
                LinkedList<Integer> list = new LinkedList<>();
                list.addLast(1);
                list.addLast(2);
                list.addLast(3);

                System.out.println("Size: " + list.size()); // Output: 3
                System.out.println("Remove first: " + list.removeFirst()); // Output: 1
                System.out.println("Size after removal: " + list.size()); // Output: 2
            }
        }
