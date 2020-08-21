package main.java.solutions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RankTransformOfAnArray1331 {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x:arr) q.offer(x);
        int rank = 1;
        Map<Integer,Integer> vr = new HashMap<>();
        while(!q.isEmpty()){
            Integer x = q.poll();
            if(!vr.containsKey(x)) vr.put(x,rank++);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = vr.get(arr[i]);
        }
        return arr;
    }

    public int[] arrayRankTransform2(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int rank = 1;
        Map<Integer,Integer> vr = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!vr.containsKey(sorted[i])) {
                vr.put(sorted[i], rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = vr.get(arr[i]);
        }
        return arr;
    }
}
