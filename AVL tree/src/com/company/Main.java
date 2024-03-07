package com.company;

public class Main {

    public static void main(String[] args) {
        public class AVLTree {
            private Node root;

            private static class Node {
                private int data;
                private int height;
                private Node left;
                private Node right;

                public Node(int data) {
                    this.data = data;
                    this.height = 1;
                    this.left = null;
                    this.right = null;
                }
            }

            public AVLTree() {
                root = null;
            }

            private int height(Node node) {
                return node == null ? 0 : node.height;
            }

            private int balanceFactor(Node node) {
                return node == null ? 0 : height(node.left) - height(node.right);
            }

            private Node rightRotate(Node y) {
                Node x = y.left;
                Node T = x.right;

                x.right = y;
                y.left = T;

                y.height = Math.max(height(y.left), height(y.right)) + 1;
                x.height = Math.max(height(x.left), height(x.right)) + 1;

                return x;
            }

            private Node leftRotate(Node x) {
                Node y = x.right;
                Node T = y.left;

                y.left = x;
                x.right = T;

                x.height = Math.max(height(x.left), height(x.right)) + 1;
                y.height = Math.max(height(y.left), height(y.right)) + 1;

                return y;
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
                } else {
                    return root; // Duplicate keys not allowed
                }

                root.height = 1 + Math.max(height(root.left), height(root.right));

                int balance = balanceFactor(root);

                // Left Left Case
                if (balance > 1 && data < root.left.data) {
                    return rightRotate(root);
                }

                // Right Right Case
                if (balance < -1 && data > root.right.data) {
                    return leftRotate(root);
                }

                // Left Right Case
                if (balance > 1 && data > root.left.data) {
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }

                // Right Left Case
                if (balance < -1 && data < root.right.data) {
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }

                return root;
            }

            private void inorderTraversalRecursive(Node root) {
                if (root != null) {
                    inorderTraversalRecursive(root.left);
                    System.out.print(root.data + " ");
                    inorderTraversalRecursive(root.right);
                }
            }

            public void inorderTraversal() {
                inorderTraversalRecursive(root);
            }

            public static void main(String[] args) {
                AVLTree tree = new AVLTree();
                tree.insert(10);
                tree.insert(5);
                tree.insert(15);
                tree.insert(7);
                tree.insert(12);

                System.out.println("Inorder traversal:");
                tree.inorderTraversal(); // Output: 5 7 10 12 15
            }
        }
    }
}