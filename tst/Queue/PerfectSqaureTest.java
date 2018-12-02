package Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerfectSqaureTest {
    @Test
    public void testPerfectSquares() {
        PerfectSquares perfectSquares = new PerfectSquares();
        Assertions.assertEquals(3, perfectSquares.numSquares(12));
    }
}
