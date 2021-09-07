public class Islands {
    //rows and columns
    static final int ROW = 5, COL = 5;

    //can include or not
    static boolean isSafe(int[][] mat, int row, int col, boolean[][] visited) {
        return (row>=0) && (row<ROW) && (col>=0) && (col<COL) && (mat[row][col]==1 && !visited[row][col]);
    }

    static void DFS(int[][] mat, int row, int col, boolean[][] visited) {
        // can go in 8 directions
        int rowNbr[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        //recur for all connected neighbours
        for (int i = 0; i < 8; i++) {
            if(isSafe(mat, row+rowNbr[i],col+colNbr[i], visited)) {
                DFS(mat, row+rowNbr[i],col+colNbr[i], visited);
            }
        }
    }

    static int countIslands(int[][] mat) {
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(mat[i][j] == 1 && !visited[i][j]) {
                    DFS(mat, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int mat[][] = new int[][] {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        Islands I = new Islands();
        System.out.println(I.countIslands(mat));
    }
}
