public class Fill {
    static void floodFillUtil(int screen[][], int i, int j, int beforeC, int afterC, int M, int N) {
        //base cases
        if(i<0 || i>=M || j<0 || j>=N) return;
        if(screen[i][j]!=beforeC) return;

        //replace the color at (i,j) with the new color
        screen[i][j] = afterC;

        floodFillUtil(screen, i+1, j, beforeC, afterC, M, N);
        floodFillUtil(screen, i-1, j, beforeC, afterC, M, N);
        floodFillUtil(screen, i, j+1, beforeC, afterC, M, N);
        floodFillUtil(screen, i, j-1, beforeC, afterC, M, N);
    }

    static void floodFill(int screen[][], int i, int j, int afterC) {
        int beforeC = screen[i][j];
        if(beforeC==afterC) return;
        floodFillUtil(screen, i, j, beforeC, afterC, 8, 8);
    }

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        floodFill(screen, 4, 4, 3);
        System.out.println("After filling the color: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
