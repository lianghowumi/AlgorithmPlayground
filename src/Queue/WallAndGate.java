package Queue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class WallAndGate {
    public void solution(int[][] rooms) {
        if (Objects.isNull(rooms)) return;
        if (rooms.length == 0) return;
        if (rooms[0].length == 0) return;

        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> updated = new LinkedList<>();
        // find gates
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    updated.add(new int[] {i, j});
                }
            }
        }
        while (!updated.isEmpty()) {
            int[] cur = updated.poll();
            int i = cur[0];
            int j = cur[1];
            // update neighbors
            if (i-1 >= 0 && rooms[i-1][j] == Integer.MAX_VALUE) {
                rooms[i-1][j] = rooms[i][j] + 1;
                updated.add(new int[] {i-1, j});
            }
            if (j+1 < col && rooms[i][j+1] == Integer.MAX_VALUE) {
                rooms[i][j+1] = rooms[i][j] + 1;
                updated.add(new int[] {i, j+1});
            }
            if (i+1 < row && rooms[i+1][j] == Integer.MAX_VALUE) {
                rooms[i+1][j] = rooms[i][j] + 1;
                updated.add(new int[] {i+1, j});
            }
            if (j-1 >= 0 && rooms[i][j-1] == Integer.MAX_VALUE) {
                rooms[i][j-1] = rooms[i][j] + 1;
                updated.add(new int[] {i, j-1});
            }
        }
        return;
    }

    /*
    public void solution(int[][] rooms) {
        if (Objects.isNull(rooms)) return;
        if (rooms.length == 0) return;
        if (rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 2147483647) {
                    rooms[i][j] = getDistance(i, j, rooms);
                }
            }
        }
    }

    *//**
     * input: 2D array rooms, starting point (i, j)
     * output: distance from (i,j) to nearest 0
     *//*
    private int getDistance(int i, int j, int[][] rooms) {
        int maxRow = rooms.length;
        int maxCol = rooms[0].length;
        // store entry pending to be visited
        Queue<int[]> toVisit = new LinkedList<>();
        // store visited entry
        boolean[][] visited = new boolean[maxRow][maxCol];
        toVisit.add(new int[] {i, j});
        int distance = 0;
        while(!toVisit.isEmpty()) {
            int sizeInThisLayer = toVisit.size();
            for (int k = 0; k < sizeInThisLayer; k++) {
                int[] cur = toVisit.poll();
                int row = cur[0];
                int col = cur[1];
                visited[row][col] = true;
                if (rooms[row][col] == -1) {
                    continue;
                } else if (rooms[row][col] == 0) {
                    return distance;
                } else {
                    // above
                    if (row - 1 >= 0 && !visited[row-1][col]) {
                        toVisit.add(new int[] {row-1, col});
                    }
                    // left
                    if (col - 1 >= 0 && !visited[row][col-1]) {
                        toVisit.add(new int[] {row, col-1});
                    }
                    // right
                    if (col + 1 < maxCol && !visited[row][col+1]) {
                        toVisit.add(new int[] {row, col+1});
                    }
                    // down
                    if (row + 1 < maxRow && !visited[row+1][col]) {
                        toVisit.add(new int[] {row+1, col});
                    }
                }
            }
            distance += 1;
        }
        // in case that no available gate exists
        return Integer.MAX_VALUE;
    }
    */
}