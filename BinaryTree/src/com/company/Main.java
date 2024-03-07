package com.company;

public class Main {

    public static void main(String[] args) {
        public class BinaryTree {
            private Node root;

            private static class Node {
                private int data;
                private Node left;
                private Node right;

                public Node(int data) {
                    this.data = data;
                    this.left = null;
                    this.right = null;
                }
            }

            public BinaryTree() {
                root = null;
            }

            public void insert(int data) {
                root = insertRecursive(root, data);
            }

            private Node insertRecursive(Node root, int data) {
                if (root == null) {
                    return new Node(data);
                }

                if (data < root.data) {
                    root.left = insertRecursive(root.left, data);
                } else if (data > root.data) {
                    root.right = insertRecursive(root.right, data);
                }

                return root;
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
                BinaryTree tree = new BinaryTree();
                tree.insert(10);
                tree.insert(5);
                tree.insert(15);
                tree.insert(7);
                tree.insert(12);

                System.out.println("Inorder traversal:");
                tree.inorderTraversal(); 
            }
        }
    }
}
