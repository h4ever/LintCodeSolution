package solutions.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight1046 {
    /*
    We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.

At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000

     */
    public static   int lastStoneWeight(int[] stones) {
        Queue<Integer> util = new PriorityQueue<>(stones.length,Comparator.reverseOrder());
        for(int stone:stones){
            util.offer(stone);
        }
        while(util.size()>1){
            util.offer(util.poll()-util.poll());
        }
        return util.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1,8};
        lastStoneWeight(stones);

    }
}
