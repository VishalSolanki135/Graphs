import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        int n, m;
        n = 10;
        m = 13;

        Main graph = new Main(n);

        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(2, 3);
        addEdge(2, 8);
        addEdge(2, 9);
        addEdge(3, 6);
        addEdge(4, 6);
        addEdge(4, 8);
        addEdge(5, 8);
        addEdge(6, 7);
        addEdge(7, 8);
        addEdge(8, 10);

        printOrder(n);
    }

    private static int V;
    private static ArrayList<ArrayList<Integer>> adj;
    static int maxN=100000;

    static int[] count = new int[maxN];
    static int[] incomingV = new int[maxN];

    Main(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    static void addEdge(int u, int v){
        adj.get(u).add(v);
        incomingV[v]++;
    }

    static void printOrder(int vertice) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if(incomingV[i]==0) {
                queue.add(i);
                count[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.peek();
            queue.remove();
            for(int node : adj.get(curr)) {
                incomingV[node]--;

                if(incomingV[node]==0) {
                    count[node] = 1 + count[curr];
                    queue.add(node);
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            System.out.print(count[i] + " ");
        }
    }
}