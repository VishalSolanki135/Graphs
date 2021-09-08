import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        Graph graph = new Graph();
        if(graph.checkbipartite(adj, n)==true) System.out.println("YES, This graph is bipartite.");
        else System.out.println("NO, This is not bipartite.");
    }

    static boolean checkbipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i]=-1;
        }

        for (int i = 0; i < n; i++) {
            if(color[i]==-1) {
                if(!bfs(i, adj, color)) return false;
            }
        }
        return true;
    }

    static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node]=1;
        while(!queue.isEmpty()) {
            int n = queue.poll();

            for (Integer i : adj.get(n)) {
                if (color[i] == -1) {
                    color[i]=1-color[n];
                    queue.add(i);
                } else if(color[i]==color[n]) return false;
            }
        }
        return true;
    }
}
