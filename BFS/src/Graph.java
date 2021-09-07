import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static int V;
    static ArrayList<ArrayList<Integer>> adj;
    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    static void BFS(int node) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]=true;

        while(!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node + " ");
            Iterator<Integer> iterator = adj.get(node).listIterator();
            while(iterator.hasNext()) {
                int n = iterator.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.BFS(0);
    }
}