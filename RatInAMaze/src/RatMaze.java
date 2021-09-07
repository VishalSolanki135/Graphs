public class RatMaze {
    static int N; //size of the maze

    void printPath(int[][] path) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + path[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean canRatGo(int[][] maze, int i, int j) {
        return (i>=0&&i<N&&j>=0&&j<N&&maze[i][j]==1);
    }

    boolean makeRatMove(int[][] maze, int i, int j, int[][] path) {
        if(i==N-1 && j==N-1 && maze[i][j]==1) {
            path[i][j]=1;
            return true;
        }

        if(canRatGo(maze, i, j)==true) {
            if(path[i][j]==1) {
                return false;
            }
            path[i][j]=1;
            if(makeRatMove(maze, i+1, j, path)) return true;
            if(makeRatMove(maze, i-1, j, path)) return true;
            if(makeRatMove(maze, i, j+1, path)) return true;
            if(makeRatMove(maze, i, j-1, path)) return true;

            //if rat cannot move anywhere, then backtrack!
            path[i][j]=0;
            return false;
        }
        return false;
    }

    boolean solveMaze(int[][] maze) {
        int[][] path = new int[N][N];
        if(!makeRatMove(maze, 0, 0, path)) { System.out.println("Rat cannot reach it's destination!"); return false;}
        printPath(path);
        return true;
    }

    public static void main(String[] args) {
        RatMaze ratMaze = new RatMaze();
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        N = maze.length;
        ratMaze.solveMaze(maze);
    }
}
