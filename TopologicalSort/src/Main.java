import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main g = new Main(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }

    private static int V;
    private static ArrayList<ArrayList<Integer>> adj;
    Main(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    static void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex]=true;
        Iterator<Integer> iterator = adj.get(vertex).listIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(vertex);
    }

    static void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if(!visited[i]) topologicalSortUtil(i, visited, stack);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}