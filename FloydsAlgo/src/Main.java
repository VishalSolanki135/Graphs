//Time complexity is O(N^3) where N is the number of vertices.

public class Main {
    static int INFINTE = 99999, V= 4;
    static void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSol(dist);
    }

    static void printSol(int[][] dist) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INFINTE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 5, INFINTE, 10},
                         {INFINTE, 0, 3, INFINTE},
                         {INFINTE, INFINTE, 0, 1},
                         {INFINTE, INFINTE, INFINTE, 0}};

        Main main = new Main();
        main.floydWarshall(graph);
    }
}
