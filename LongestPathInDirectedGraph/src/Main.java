import java.util.ArrayList;

public class Main {
    static class Node {
        int u,v,weight;
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

    static void longestPath(ArrayList<Node> adj, int src, int n) {
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i]=Integer.MIN_VALUE;
        }
        dist[src]=0;

        for (int i = 1; i < n-1; i++) {
            for (Node node : adj) {
                if(dist[node.getV()] < dist[node.getU()] + node.getWeight()) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();

        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, 5));
        adj.add(new Node(1, 4, 2));
        adj.add(new Node(5, 2, 50));
        adj.add(new Node(4, 2, 10));
        adj.add(new Node(5, 3, 2));
        adj.add(new Node(3, 2, 20));

        Main obj = new Main();
        obj.longestPath(adj, 1, n);
    }
}
