package dsa.tasks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class UndirectedGraph {

    private int V; 
    private Map<Integer, List<Integer>> adj; 

    public UndirectedGraph() {
        V = 0;
        adj = new HashMap<>();
    }

    public void addVertex(int v) {
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<>());
            V++;
        }
    }

    public void addEdge(int u, int v) {
        if (!adj.containsKey(u))
            addVertex(u);
        if (!adj.containsKey(v))
            addVertex(v);

        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    public void removeVertex(int v) {
        if (!adj.containsKey(v))
            return;

        for (int neighbor : adj.get(v)) {
            adj.get(neighbor).remove(Integer.valueOf(v)); 
        }
        adj.remove(v);
        V--;
    }

    public void removeEdge(int u, int v) {
        if (adj.containsKey(u)) {
            adj.get(u).remove(Integer.valueOf(v));
        }
        if (adj.containsKey(v)) {
            adj.get(v).remove(Integer.valueOf(u));
        }
    }

    public boolean hasVertex(int v) {
        return adj.containsKey(v);
    }

    public boolean hasEdge(int u, int v) {
        if (!adj.containsKey(u))
            return false;
        return adj.get(u).contains(v);
    }

    // Perform Depth-First Search (DFS) traversal 
    public List<Integer> dfs(int v) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsHelper(v, visited, result);
        return result;
    }

    private void dfsHelper(int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }

    // Perform Breadth-First Search (BFS) traversal 
    public List<Integer> bfs(int v) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> graphQueue = new LinkedList<>();

        visited[v] = true;
        graphQueue.offer(v);

        while (!graphQueue.isEmpty()) {
            int u = graphQueue.poll();
            result.add(u);

            for (int neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    graphQueue.offer(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	UndirectedGraph graph = new UndirectedGraph();

        // Adding vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("DFS Traversal:");
        List<Integer> dfsTraversal = graph.dfs(0);
        for (int vertex : dfsTraversal) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        System.out.println("BFS Traversal:");
        List<Integer> bfsTraversal = graph.bfs(0);
        for (int vertex : bfsTraversal) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        graph.removeEdge(1, 3);

        graph.removeVertex(2);

        System.out.println("Edge (0, 1) exists? " + graph.hasEdge(0, 1));

        System.out.println("Vertex 2 exists? " + graph.hasVertex(2));
    }
}