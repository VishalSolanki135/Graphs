import java.util.ArrayList;

public class Main {
    static class Node {
        int u, v, weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    static void bellmanAlgo(ArrayList<Node> graph, int src, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 1000000;
        }

        dist[src] = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (Node node : graph) {
                if (dist[node.getV()] > dist[node.getU()] + node.getWeight()) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        int flag = 0;
        for (Node node : graph) {
            if (dist[node.getV()] > dist[node.getU()] + node.getWeight()) {
                flag = 1;
                System.out.println("Negative Cycle Exist.");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("No negative cycle exist.");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();


        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));


        Main obj = new Main();
        obj.bellmanAlgo(adj, 0, n);
    }
}
