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

    static void bellmanAlgo(ArrayList<Node> adj, int src, int N ){
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = 10000000;
        }
        dist[src] = 0;
        for (int i = 1; i <= N-1; i++) {
            for (Node node : adj) {
                if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        int flag = 0;
        for (Node node : adj) {
            if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                flag=1;
                System.out.println("Negative cycle exists. ");
                break;
            }
        }

        if(flag==0) {
            for (int i = 0; i < N; i++) {
                System.out.println(i + " " + dist[i]);
            }
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