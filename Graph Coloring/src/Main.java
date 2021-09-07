import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {{1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 3},
                {2, 4}};

        int[] ans = gardenNoAdj(n, graph);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static int[] gardenNoAdj(int n, int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = matToADJ(graph, n);

        int[] color = new int[n];
        List<Integer> list = new ArrayList<>();
        graphColoring(adj, color, 4, 0, n, list);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    static boolean graphColoring(ArrayList<ArrayList<Integer>> adj, int[] color, int m, int node, int n, List<Integer> list) {
        if(node==n){
            for (int i = 0; i < color.length; i++) {
                if(color[i]!=0) {
                    list.add(color[i]);
                }
            }
            return true;
        }

        for (int i = 1; i <=m ; i++) {
            if(isValid(adj, color, i, node)) {
                color[node]=i;
                if(graphColoring(adj, color, i, node+1, n, list)) return true;
                color[node]=0;
            }
        }
        return false;
    }

    static boolean isValid(ArrayList<ArrayList<Integer>> adj, int[] color, int currColor, int node){
        for (int i = 0; i < adj.get(node).size(); i++) {
            if(color[adj.get(node).get(i)]==currColor) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<ArrayList<Integer>> matToADJ(int[][] graph, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            adj.get(graph[i][0]-1).add(graph[i][1]-1);
            adj.get(graph[i][1]-1).add(graph[i][0]-1);
        }
        return adj;
    }
}