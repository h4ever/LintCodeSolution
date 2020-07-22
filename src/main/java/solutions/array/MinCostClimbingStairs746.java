package main.java.solutions.array;

public class MinCostClimbingStairs746 {
    /*
     On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
     */
    public static  int minCostClimbingStairs(int[] cost) {
        int oneStepBefore = cost[1], twoStepBefore = cost[0];
        for (int i = 2; i < cost.length; i++) {
            int currCost = cost[i]+Math.min(oneStepBefore,twoStepBefore);
            twoStepBefore = oneStepBefore;
            oneStepBefore = currCost;
        }
        return Math.min(oneStepBefore,twoStepBefore);
    }
}
