package Queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WallAndGateTest {
    private static int[][] wallAndGateRooms;

    @Test
    public void testHappyPath() {
        wallAndGateRooms = new int[][]{
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        WallAndGate wallAndGate = new WallAndGate();
        wallAndGate.solution(wallAndGateRooms);
        System.out.println(Arrays.deepToString(wallAndGateRooms));
    }

    @Test
    public void testNoGate() {
        wallAndGateRooms = new int[][]{
                {Integer.MAX_VALUE, -1, -1, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        WallAndGate wallAndGate = new WallAndGate();
        wallAndGate.solution(wallAndGateRooms);
        System.out.println(Arrays.deepToString(wallAndGateRooms));
    }
}
