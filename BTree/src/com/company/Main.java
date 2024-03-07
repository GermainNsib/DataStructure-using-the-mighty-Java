package com.company;

public class Main {

    public static void main(String[] args) {
        public class BTree {
            private static final int T = 2; // Minimum degree
            private Node root;

            private static class Node {
                private int n; // Number of keys in the node
                private int[] keys; // Array of keys
                private Node[] children; // Array of child pointers
                private boolean leaf; // Whether the node is a leaf

                public Node(int n, boolean leaf) {
                    this.n = n;
                    this.keys = new int[2 * T - 1];
                    this.children = new Node[2 * T];
                    this.leaf = leaf;
                }
            }

            public BTree() {
                root = null;
            }

            public void insert(int key) {
                if (root == null) {
                    root = new Node(0, true);
                    root.keys[0] = key;
                    root.n = 1;
                } else {
                    if (root.n == 2 * T - 1) {
                        Node newRoot = new Node(0, false);
                        newRoot.children[0] = root;
                        splitChild(newRoot, 0);
                        int i = 0;
                        if (newRoot.keys[0] < key) {
                            i++;
                        }
                        insertNonFull(newRoot.children[i], key);
                        root = newRoot;
                    } else {
                        insertNonFull(root, key);
                    }
                }
            }

            private void insertNonFull(Node node, int key) {
                int i = node.n - 1;
                if (node.leaf) {
                    while (i >= 0 && key < node.keys[i]) {
                        node.keys[i + 1] = node.keys[i];
                        i--;
                    }
                    node.keys[i + 1] = key;
                    node.n++;
                } else {
                    while (i >= 0 && key < node.keys[i]) {
                        i--;
                    }
                    i++;
                    if (node.children[i].n == 2 * T - 1) {
                        splitChild(node, i);
                        if (key > node.keys[i]) {
                            i++;
                        }
                    }
                    insertNonFull(node.children[i], key);
                }
            }

            private void splitChild(Node parent, int i) {
                Node child = parent.children[i];
                Node newChild = new Node(T - 1, child.leaf);
                for (int j = 0; j < T - 1; j++) {
                    newChild.keys[j] = child.keys[j + T];
                }
                if (!child.leaf) {
                    for (int j = 0; j < T; j++) {
                        newChild.children[j] = child.children[j + T];
                    }
                }
                child.n = T - 1;
                for (int j = parent.n; j > i; j--) {
                    parent.children[j + 1] = parent.children[j];
                }
                parent.children[i + 1] = newChild;
                for (int j = parent.n - 1; j >= i; j--) {
                    parent.keys[j + 1] = parent.keys[j];
                }
                parent.keys[i] = child.keys[T - 1];
                parent.n++;
            }

            public void print() {
                printRecursive(root, "");
            }

            private void printRecursive(Node node, String indent) {
                if (node != null) {
                    System.out.print(indent);
                    for (int i = 0; i < node.n; i++) {
                        System.out.print(node.keys[i] + " ");
                    }
                    System.out.println();
                    if (!node.leaf) {
                        for (int i = 0; i <= node.n; i++) {
                            printRecursive(node.children[i], indent + "  ");
                        }
                    }
                }
            }

            public static void main(String[] args) {
                BTree bTree = new BTree();
                bTree.insert(1);
                bTree.insert(3);
                bTree.insert(7);
                bTree.insert(10);
                bTree.insert(11);
                bTree.insert(13);
                bTree.insert(14);
                bTree.insert(15);
                bTree.insert(18);
                bTree.insert(16);
                bTree.insert(19);
                bTree.insert(24);
                bTree.insert(25);
                bTree.insert(26);
                bTree.insert(21);
                bTree.insert(4);
                bTree.insert(5);
                bTree.insert(20);
                bTree.insert(22);
                bTree.insert(2);
                bTree.insert(17);
                bTree.print();
            }
        }
    }
}