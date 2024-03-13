package com.company;

public class Main {

    public static void main(String[] args) {
        class Graph {
            private final int vertices;
            private final boolean[][] adjacencyMatrix;

            public Graph(int vertices) {
                this.vertices = vertices;
                adjacencyMatrix = new boolean[vertices][vertices];
            }

            public void addEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    adjacencyMatrix[source][destination] = true;
                    adjacencyMatrix[destination][source] = true; // For undirected graph
                } else {
                    System.out.println("Invalid edge");
                }
            }

            public void removeEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    adjacencyMatrix[source][destination] = false;
                    adjacencyMatrix[destination][source] = false; // For undirected graph
                } else {
                    System.out.println("Invalid edge");
                }
            }

            public boolean isEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    return adjacencyMatrix[source][destination];
                } else {
                    System.out.println("Invalid edge");
                    return false;
                }
            }

            public void printAdjacencyMatrix() {
                for (int i = 0; i < vertices; i++) {
                    for (int j = 0; j < vertices; j++) {
                        System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
                    }
                    System.out.println();
                }
            }
        }

        public class Main {
            public static void main(String[] args) {
                int vertices = 5;
                Graph graph = new Graph(vertices);
                graph.addEdge(0, 1);
                graph.addEdge(0, 2);
                graph.addEdge(1, 2);
                graph.addEdge(2, 3);
                graph.addEdge(3, 4);

                graph.printAdjacencyMatrix();

                System.out.println("Removing edge between 0 and 2");
                graph.removeEdge(0, 2);
                graph.printAdjacencyMatrix();

                System.out.println("Is there an edge between 1 and 2? " + graph.isEdge(1, 2));
                System.out.println("Is there an edge between 3 and 4? " + graph.isEdge(3, 4));
            }
        }
        class Graph {
            private final int vertices;
            private final boolean[][] adjacencyMatrix;

            public Graph(int vertices) {
                this.vertices = vertices;
                adjacencyMatrix = new boolean[vertices][vertices];
            }

            public void addEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    adjacencyMatrix[source][destination] = true;
                    adjacencyMatrix[destination][source] = true; // For undirected graph
                } else {
                    System.out.println("Invalid edge");
                }
            }

            public void removeEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    adjacencyMatrix[source][destination] = false;
                    adjacencyMatrix[destination][source] = false; // For undirected graph
                } else {
                    System.out.println("Invalid edge");
                }
            }

            public boolean isEdge(int source, int destination) {
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    return adjacencyMatrix[source][destination];
                } else {
                    System.out.println("Invalid edge");
                    return false;
                }
            }

            public void printAdjacencyMatrix() {
                for (int i = 0; i < vertices; i++) {
                    for (int j = 0; j < vertices; j++) {
                        System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
                    }
                    System.out.println();
                }
            }
        }

        public class Main {
            public static void main(String[] args) {
                int vertices = 5;
                Graph graph = new Graph(vertices);
                graph.addEdge(0, 1);
                graph.addEdge(0, 2);
                graph.addEdge(1, 2);
                graph.addEdge(2, 3);
                graph.addEdge(3, 4);

                graph.printAdjacencyMatrix();

                System.out.println("Removing edge between 0 and 2");
                graph.removeEdge(0, 2);
                graph.printAdjacencyMatrix();

                System.out.println("Is there an edge between 1 and 2? " + graph.isEdge(1, 2));
                System.out.println("Is there an edge between 3 and 4? " + graph.isEdge(3, 4));
            }
        }
    }
}