import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparator<Node> {
        private int node;
        private int weight;

        Node(int _v, int _w) { node=_v; weight=_w; }
        Node() {}
        int getNode() { return node; }
        int getWeight() { return weight; }


        @Override//this helps the priority queue to be set as a minimal priority queue.(automatically sorts acc to the weight)
        public int compare(Node node1, Node node2) {
            if(node1.weight<node2.weight) return -1;
            if(node1.weight>node2.weight) return 1;
            return 0;
        }
    }

    static void shortestPath(int src, ArrayList<ArrayList<Node>> adj, int N) {
        int[] distanceArray = new int[N];//to store the distance of each node from src.

        for (int i = 0; i < N; i++) distanceArray[i] = 100000000;
        distanceArray[src] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(N, new Node());//(initial capacity, comparator)
        priorityQueue.add(new Node(src, 0));//(node, distance)

        while(priorityQueue.size()>0) {
            Node node = priorityQueue.poll();
            for(Node value: adj.get(node.getNode())) {
                if(node.getWeight() + value.getWeight() < distanceArray[value.getNode()]) {
                    distanceArray[value.getNode()] = node.getWeight() + value.getWeight();
                    priorityQueue.add(new Node(value.getNode(), distanceArray[value.getNode()]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("The shortest path from src 0 to " + i + " is " + distanceArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Node>());
        }
        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        Main obj = new Main();
        obj.shortestPath(0, adj, n);

    }
}
