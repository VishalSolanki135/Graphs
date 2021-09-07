import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        Main obj = new Main();
        obj.kosarajuAlgo(adj, n);
    }

    static void kosarajuAlgo(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                dfs(i, stack, adj, visited);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            visited[i]=0;
            for (Integer it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }

        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            if(visited[node]==0) {
                revDFS(node, transpose, visited);
                System.out.println();
            }
        }
    }

    static void dfs(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node]=1;
        Iterator<Integer> iterator = adj.get(node).listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if(visited[n]==0) {
                dfs(n, stack, adj, visited);
            }
        }
        stack.push(node);
    }

    static void revDFS(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node]=1;
        System.out.print(node + " ");
        Iterator<Integer> iterator = adj.get(node).listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if(visited[n]==0) revDFS(n, adj,visited );
        }
    }
}