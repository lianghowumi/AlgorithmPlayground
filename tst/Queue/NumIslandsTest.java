package Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {
    private static char[][] grid;

    @Test
    public void testHappyPath() {
        grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        Assertions.assertEquals(1, numIslands.numIslands(grid));
    }
}
