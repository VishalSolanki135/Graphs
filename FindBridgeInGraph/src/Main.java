import java.util.ArrayList;

public class Main{
    static int V;
    static ArrayList<ArrayList<Integer>> adj;
    Main(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    Main() {}

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printBridge(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] visited = new int[n];
        int[] TIn = new int[n];
        int[] LIn = new int[n];

        int timer = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]==0) {
                dfs(i, -1, visited, TIn, LIn, adj, n, timer);
            }
        }
    }

    static void dfs(int node, int parent, int[] visited, int[] TIn, int[] LIn, ArrayList<ArrayList<Integer>> adj, int n, int timer) {
        visited[node]=1;
        TIn[node] = LIn[node] = timer++;
        for(Integer it : adj.get(node)) {
            if(it==parent) continue;//bcoz hame parent se na hi lowest time chahiye na hi insertion time kyun ki whin se to wo aaya hai
            if(visited[it] == 0) {
                dfs(it, node, visited, TIn, LIn, adj, n, timer);
                LIn[node] = Math.min(LIn[it], LIn[node]);

                if(LIn[it] > TIn[node]) System.out.println(it + " " + node);
            } else {
                LIn[node] = Math.min(LIn[node], TIn[it]);
            }

        }
    }

    public static void main(String[] args) {
        Main graph = new Main(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        Main obj = new Main();
        obj.printBridge(adj, 5);
    }
}