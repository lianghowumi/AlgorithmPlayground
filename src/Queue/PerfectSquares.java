package Queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] count = new int[n+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j*j <= i; j++) {
                int square = j*j;
                count[i] = Math.min(count[i-square] + 1, count[i]);
            }
        }
        return count[n];
    }
    // BFS
    public int numSquares_BFS(int n) {
        if (n <= 0) return 0;
        List<Integer> perfect = new ArrayList<>();

        // find out all perfect squares
        for (int i = 1; i <= n; i++) {
            if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i) {
                if (i == n) return 1;
                perfect.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer i : perfect) {
            queue.add(i);
            visited.add(i);
        }

        /**
         * Imagine as a graph consist of node 1,2,3...,n
         * If there is an edge between node i and j, then
         *   either i + a perfect square = j OR
         *          j + a perfect square = i
         * The question now is eqaul to finding a shortest path from node 0 to node n
         */

        int step = 1;
        while(!queue.isEmpty()) {
            step++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int top = queue.poll();
                // check neighbors
                for (int edge : perfect) {
                    int neighbor = top + edge;
                    if (neighbor == n) {
                        return step;
                    }
                    if (neighbor > n) {
                        break;
                    }
                    else if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }
}
