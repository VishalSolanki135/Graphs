import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    static int V;
    static LinkedList<Integer> adj[];

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    boolean isCyclicUtil(int node, boolean[] visited, int parent) {
        visited[node] = true;
        Integer i;

        Iterator<Integer> iterator = adj[node].listIterator();
        while(iterator.hasNext()) {
            i = iterator.next();
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, node)) return true;
            } else if(i!=parent) return true;
        }
        return false;
    }
    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {

        // Create a graph given
        // in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("YES");
        else
            System.out.println("NO");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
