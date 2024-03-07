package com.company;

public class Main {

    public static void main(String[] args) {
        public class RedBlackTree {
            private Node root;
            private static final boolean RED = false;
            private static final boolean BLACK = true;

            private static class Node {
                int data;
                Node left, right, parent;
                boolean color;

                public Node(int data) {
                    this.data = data;
                    this.color = RED;
                    this.left = this.right = this.parent = null;
                }
            }

            public RedBlackTree() {
                root = null;
            }

            private Node insertRecursive(Node root, Node parent, int data) {
                if (root == null) {
                    root = new Node(data);
                    root.parent = parent;
                    return root;
                }

                if (data < root.data) {
                    root.left = insertRecursive(root.left, root, data);
                } else if (data > root.data) {
                    root.right = insertRecursive(root.right, root, data);
                }

                if (isRed(root.right) && !isRed(root.left)) {
                    root = rotateLeft(root);
                }
                if (isRed(root.left) && isRed(root.left.left)) {
                    root = rotateRight(root);
                }
                if (isRed(root.left) && isRed(root.right)) {
                    flipColors(root);
                }

                return root;
            }

            public void insert(int data) {
                root = insertRecursive(root, null, data);
                root.color = BLACK;
            }

            private boolean isRed(Node node) {
                if (node == null) {
                    return false;
                }
                return node.color == RED;
            }

            private Node rotateLeft(Node h) {
                Node x = h.right;
                h.right = x.left;
                x.left = h;
                x.color = h.color;
                h.color = RED;
                return x;
            }

            private Node rotateRight(Node h) {
                Node x = h.left;
                h.left = x.right;
                x.right = h;
                x.color = h.color;
                h.color = RED;
                return x;
            }

            private void flipColors(Node h) {
                h.color = RED;
                h.left.color = BLACK;
                h.right.color = BLACK;
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
                RedBlackTree tree = new RedBlackTree();
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
