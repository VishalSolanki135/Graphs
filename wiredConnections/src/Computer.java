import java.util.ArrayList;
import java.util.HashMap;

class Computer {
    static void DFS(HashMap<Integer, ArrayList<Integer>> adj, int node, boolean[] visited) {
        if(visited[node]) return;
        visited[node]=true;

        for(int x : adj.get(node)) {
            if(!visited[x]) {
                DFS(adj, x, visited);
            }
        }
    }

    static int makeConnectionsUtil(int N, int[][] connections, int M) {
        //N = number of vertices, M = number of edges, connections = edges
        boolean[] visited = new boolean[N];

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        //count of edges
        int edges = 0;
        for (int i = 0; i < M; ++i) {
            //get the neighbours
            ArrayList<Integer> l1 = adj.get(connections[i][0]);
            ArrayList<Integer> l2 = adj.get(connections[i][1]);

            //add edges
            l1.add(connections[i][1]);
            l2.add(connections[i][0]);

            edges+=1;
        }

        //count the components
        int components = 0;
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                components+=1;
                DFS(adj, i, visited);
            }
        }

        //at least N-1 edges are required
        if(edges<N-1) {
            return -1;
        }

        //count redundant edges
        int redundant = edges - ((N-1) - (components-1));
        if(redundant>=(components-1)) return components-1;
        return -1;
    }

    static void makeConnections(int N, int connections[][], int M) {
        int minOps = makeConnectionsUtil(N, connections, M);
        System.out.println(minOps);
    }

    public static void main(String[] args) {
        int N = 6;
        int connections[][] = {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        int M = connections.length;
        makeConnections(N, connections, M);
    }
}