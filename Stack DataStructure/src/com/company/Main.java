package com.company;
import java.util.EmptyStackException;


        public class Stack<T> {
            private Node<T> top;

            private static class Node<T> {
                private T data;
                private Node<T> next;

                public Node(T data) {
                    this.data = data;
                }
            }

            public void push(T item) {
                Node<T> newNode = new Node<>(item);
                newNode.next = top;
                top = newNode;
            }

            public T pop() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                }
                T data = top.data;
                top = top.next;
                return data;
            }

            public T peek() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                }
                return top.data;
            }

            public boolean isEmpty() {
                return top == null;
            }

            public static void main(String[] args) {
                Stack<Integer> stack = new Stack<>();
                stack.push(1);
                stack.push(2);
                stack.push(3);

                System.out.println("Pop: " + stack.pop()); // Output: 3
                System.out.println("Peek: " + stack.peek()); // Output: 2
                System.out.println("Is Empty: " + stack.isEmpty()); // Output: false
            }
        }


















    }
}
