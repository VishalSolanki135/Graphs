public class Main {
    static int minHamiltonian(int[][] graph, boolean[] visited, int currPos, int n, int count, int cost, int ans){
        if(count==n && graph[currPos][0]>0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]&&graph[currPos][i]>0) {
                visited[i] = true;
                ans = minHamiltonian(graph, visited, i, n, count+1, cost+graph[currPos][i], ans);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {{0, 10, 15, 20},
                         {5, 0, 9, 10},
                         {6, 13, 0, 12},
                         {8, 8, 9, 0}};
        boolean[] V = new boolean[n];
        V[0] = true;
        int ans = Integer.MAX_VALUE;
        ans = minHamiltonian(graph, V, 0, n, 1, 0, ans);
        System.out.println(ans);
    }
}
