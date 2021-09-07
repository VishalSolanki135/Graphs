import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    static int V;
    static List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
    }
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    boolean isCyclicUtil(int node, boolean[] visited, boolean[] order) {
        if(order[node]) return true;
        if(visited[node]) return false;

        visited[node] = true;
        order[node] = true;
        List<Integer> list = adj.get(node);
        for(Integer i : list) {
            if(isCyclicUtil(i, visited, order)) return true;
        }
        order[node] = false;
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] order = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(isCyclicUtil(i, visited, order)) return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
