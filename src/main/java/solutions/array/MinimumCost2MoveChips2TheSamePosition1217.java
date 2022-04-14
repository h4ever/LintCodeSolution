package solutions.array;

public class MinimumCost2MoveChips2TheSamePosition1217 {
    /*
    We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position, In one step, we can change the position of the ith chip from position[i] to:

    position[i] + 2 or position[i] - 2 with cost = 0.
    position[i] + 1 or position[i] - 1 with cost = 1.

Return the minimum cost needed to move all the chips to the same position.
     */

    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for(int i = 0; i < chips.length; i++)
            if(chips[i] % 2 == 1)  odd++;
            else even++;
        return Math.min(odd, even);
    }
}
