package solutions.array;

import solutions.array.MinCostClimbingStairs746;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimbingStairs746Test {

    @Test
    public void minCostClimbingStairs() {
        int[] stairs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs746.minCostClimbingStairs(stairs);
    }
}