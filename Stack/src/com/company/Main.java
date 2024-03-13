package com.company;
import java.util.Stack;
public class Main {

    public static void main(String[] args) {


        public class Main {
            public static void main(String[] args) {
                // Create a stack
                Stack<Integer> stack = new Stack<>();

                // Push elements onto the stack
                stack.push(1);
                stack.push(2);
                stack.push(3);

                // Print the stack
                System.out.println("Stack: " + stack);

                // Pop an element from the stack
                int poppedElement = stack.pop();
                System.out.println("Popped element: " + poppedElement);

                // Peek at the top element of the stack
                int topElement = stack.peek();
                System.out.println("Top element: " + topElement);

                // Check if the stack is empty
                System.out.println("Is stack empty? " + stack.isEmpty());

                // Search for an element in the stack
                int elementToSearch = 2;
                int position = stack.search(elementToSearch);
                System.out.println("Position of " + elementToSearch + " in stack: " + position);

                // Print the stack after popping all elements
                while (!stack.isEmpty()) {
                    System.out.println("Popped: " + stack.pop());
                }
            }
        }
    }
}
