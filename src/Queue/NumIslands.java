package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        // flag for visited entry
        boolean[][] visited = new boolean[row][col];
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '1') {
                    traverseIsland(i, j, grid, visited);
                    num += 1;
                }
            }
        }
        return num;
    }

    // starting at land (i,j), visiting all connected lands
    private void traverseIsland(int i, int j, char[][] grid, boolean[][] visited) {
        Queue<int[]> lands = new LinkedList<>();
        lands.add(new int[] {i, j});
        int row = grid.length;
        int col = grid[0].length;
        while(!lands.isEmpty()) {
            int size = lands.size();
            for (int s = 0; s < size; s++) {
                int[] cur = lands.poll();
                int r = cur[0];
                int c = cur[1];
                // enqueue neighbor lands
                visited[r][c] = true;
                if (r-1 >= 0 && !visited[r-1][c] && grid[r-1][c] == '1') {
                    lands.add(new int[] {r-1, c});
                    visited[r-1][c] = true;
                }
                if (c+1 < col && !visited[r][c+1] && grid[r][c+1] == '1') {
                    lands.add(new int[] {r, c+1});
                    visited[r][c+1] = true;
                }
                if (r+1 < row && !visited[r+1][c] && grid[r+1][c] == '1') {
                    lands.add(new int[] {r+1, c});
                    visited[r+1][c] = true;
                }
                if (c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] == '1') {
                    lands.add(new int[] {r, c-1});
                    visited[r][c-1] = true;
                }
            }
        }
    }
}
