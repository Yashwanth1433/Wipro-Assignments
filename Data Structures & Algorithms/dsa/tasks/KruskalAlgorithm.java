package dsa.tasks;

import java.util.*;

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); 
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalAlgorithm {

    private List<Edge> edges;
    private int V; 

    public KruskalAlgorithm(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public List<Edge> kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        
        Collections.sort(edges);
        
        UnionFind uf = new UnionFind(V);
        
        for (Edge edge : edges) {
            int rootU = uf.find(edge.u);
            int rootV = uf.find(edge.v);
            
            if (rootU != rootV) {
                mst.add(edge);
                uf.union(edge.u, edge.v);
            }
        }
        
        return mst;
    }

    public static void main(String[] args) {
        int V = 6;
        KruskalAlgorithm graph = new KruskalAlgorithm(V);

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);

        List<Edge> mst = graph.kruskalMST();

        System.out.println("Edges of the Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.u + " - " + edge.v + " : " + edge.weight);
        }
    }
}