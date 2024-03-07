package com.company;
import java.util.NoSuchElementException;

    public class QueueDS<T> {
        private Node<T> first;
        private Node<T> last;

        private static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }

        public void enqueue(T item) {
            Node<T> newNode = new Node<T>(item);
            if (isEmpty()) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            T data = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public static void main(String[] args) {
            QueueDS<Integer> queue = new QueueDS<Integer>();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.println("Dequeue: " + queue.dequeue()); 
            System.out.println("Peek: " + queue.peek());
            System.out.println("Is Empty: " + queue.isEmpty());
        }
    }
