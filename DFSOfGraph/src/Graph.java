import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    static int V; //number of vertices
    static LinkedList<Integer> adj[];//adjacent list

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void DFSUtil(int node, boolean[] visited) {
        visited[node]=true;
        System.out.println(node);
        Iterator<Integer> iterator = adj[node].listIterator();
        while(iterator.hasNext()) {
            int n = iterator.next();
            if(!visited[n]) DFSUtil(node, visited);
        }
    }

    void DFS(int node) {
        boolean[] visited = new boolean[4];
        DFSUtil(node, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);

        graph.DFS(2);
    }
}
