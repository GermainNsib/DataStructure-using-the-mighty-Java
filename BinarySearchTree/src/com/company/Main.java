package com.company;

public class Main {

    public class BinarySearchTree<T extends Comparable<T>> {
        private Node root;

        private class Node {
            private T data;
            private Node left, right;

            public Node(T data) {
                this.data = data;
                left = right = null;
            }
        }

        public BinarySearchTree() {
            root = null;
        }

        public void insert(T data) {
            root = insertRecursive(root, data);
        }

        private Node insertRecursive(Node root, T data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data.compareTo(root.data) < 0) {
                root.left = insertRecursive(root.left, data);
            } else if (data.compareTo(root.data) > 0) {
                root.right = insertRecursive(root.right, data);
            }

            return root;
        }

        public boolean search(T data) {
            return searchRecursive(root, data);
        }

        private boolean searchRecursive(Node root, T data) {
            if (root == null) {
                return false;
            }

            if (data.compareTo(root.data) == 0) {
                return true;
            }

            if (data.compareTo(root.data) < 0) {
                return searchRecursive(root.left, data);
            } else {
                return searchRecursive(root.right, data);
            }
        }

        public void inorderTraversal() {
            inorderTraversalRecursive(root);
        }

        private void inorderTraversalRecursive(Node root) {
            if (root != null) {
                inorderTraversalRecursive(root.left);
                System.out.print(root.data + " ");
                inorderTraversalRecursive(root.right);
            }
        }

        public static void main(String[] args) {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            bst.insert(10);
            bst.insert(5);
            bst.insert(15);
            bst.insert(7);
            bst.insert(12);

            System.out.println("Inorder traversal:");
            bst.inorderTraversal(); 

            System.out.println("\nSearch for 7: " + bst.search(7));
            System.out.println("Search for 20: " + bst.search(20)); 
        }
    }
}
