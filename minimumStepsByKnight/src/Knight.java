import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;

class Knight {
    static class infoOfNode {
        int i, j;
        int dis;

        public infoOfNode(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }
    static boolean isInside(int i, int j, int N) {
        if (i >= 1 && i <= N && j >= 1 && j <= N)
            return true;
        return false;
    }

    static int minDist(int[] knightPos, int targetPos[], int N) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        Vector<infoOfNode> queue = new Vector<>();
        queue.add(new infoOfNode(knightPos[0], knightPos[1], 0));
        infoOfNode info;
        int x, y;
        boolean[][] visited = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = false;
            }
        }

        visited[knightPos[0]][knightPos[1]] = true;

        while(!queue.isEmpty()) {
            info = queue.firstElement();
            queue.remove(0);

            if(info.i == targetPos[0] && info.j == targetPos[1]) {
                return info.dis;
            }
            for (int i = 0; i < 8; i++) {
                x = info.i + dx[i];
                y = info.j + dy[i];

                if(isInside(x, y, N)&&!visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new infoOfNode(x, y, info.dis+1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 30;
        int knightPos[] = {1, 1};
        int target[] = {30, 30};
        System.out.println(minDist(knightPos, target, N));
    }
}