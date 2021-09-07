import java.util.ArrayList;
import java.util.Comparator;

    class Node {
        int u, v, weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        Node() { }


        public int getU() { return u; }

        public int getV() { return v; }

        public int getWeight() { return weight; }
    }

    class SortComparator implements Comparator<Node> {


        @Override
        public int compare(Node node1, Node node2) {
            if(node1.getWeight() < node2.getWeight()) return -1;
            else if(node1.getWeight() > node2.getWeight())  return 1;
            else return 0;
        }
    }

    class Main {
    int findParent(int u, int[] parent) {
        if(parent[u] == u) return u;
        return parent[u] = findParent(parent[u], parent);//path compression
    }

    void union(int u, int v, int parent[], int rank[]) {
        int uP = findParent(u, parent);
        int vP = findParent(v, parent);

        if(rank[uP] < rank[vP]) parent[uP] = vP;
        else if(rank[vP] < rank[uP]) parent[vP] = uP;
        else{
            parent[vP] = uP;
            rank[uP]++;
        }
    }

    void kruskalAlgorithm(ArrayList<Node> adj, int N) {
        int[] rank = new int[N];
        int[] parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int minWeight = 0;
        ArrayList<Node> mst = new ArrayList<>();


        for (Node node : adj) {
            if(findParent(node.getU(), parent)!=findParent(node.getV(), parent)) {
                minWeight+=node.getWeight();
                mst.add(node);
                union(node.getU(), node.getV(), parent, rank);
            }
        }
        for (Node node : mst) {
            System.out.println(node.getU() + " " + node.getV());
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();


        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));


        Main obj = new Main();
        obj.kruskalAlgorithm(adj, n);
    }
}