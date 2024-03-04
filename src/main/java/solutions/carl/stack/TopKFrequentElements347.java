package solutions.carl.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(new int[]{entry.getKey(),entry.getValue()});
        }

        for(int i=0;i<k;i++){
            res[i] = q.poll()[0];
        }
        return  res;
    }
}
