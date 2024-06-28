package dsa.tasks;

import java.util.*;

class Edge {
    int vertex1;
    int vertex2;
    int weight;

    public Edge(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    public static void bellmanFordAlgorithm(List<Edge> edges, int numVertices, int sourceVertex) {
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[sourceVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            for (Edge edge : edges) {
                int vertex1 = edge.vertex1;
                int vertex2 = edge.vertex2;
                int weight = edge.weight;
                if (distance[vertex1] != Integer.MAX_VALUE && distance[vertex1] + weight < distance[vertex2]) {
                    distance[vertex2] = distance[vertex1] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            int vertex1 = edge.vertex1;
            int vertex2 = edge.vertex2;
            int weight = edge.weight;
            if (distance[vertex1] != Integer.MAX_VALUE && distance[vertex1] + weight < distance[vertex2]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source vertex " + sourceVertex + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int numVertices = 5;
        int sourceVertex = 0;
        bellmanFordAlgorithm(edges, numVertices, sourceVertex);
    }
}
