package dsa.tasks;

import java.util.*;

class Edge {
 int target;
 int weight;
public int src;
public int dest;

 public Edge(int target, int weight) {
     this.target = target;
     this.weight = weight;
 }
}

class Graph {
 int V; 
 List<List<Edge>> adj; 

 public Graph(int V) {
     this.V = V;
     adj = new ArrayList<>(V);
     for (int i = 0; i < V; i++) {
         adj.add(new ArrayList<>());
     }
 }

 public void addEdge(int u, int v, int weight) {
     adj.get(u).add(new Edge(v, weight));
     adj.get(v).add(new Edge(u, weight)); 
 }

public Edge[] getEdges() {
	// TODO Auto-generated method stub
	return null;
}
}
public class DijkstraAlgorithm {
    public static void dijkstra(Graph graph, int source) {
        int[] dist = new int[graph.V]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[source] = 0; 

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (Edge edge : graph.adj.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(v);
                }
            }
        }

        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < graph.V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6; 
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 8);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 7);

        int source = 0; 

        dijkstra(graph, source);
    }
}
