package main.java.solutions.array;

import java.util.LinkedList;

public class InsertInterval57 {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null||intervals.length==0) return new int[][]{{newInterval[0],newInterval[1]}};
        int m = binarySearch(intervals,newInterval[0]);
        LinkedList<int[]> res = new LinkedList<>();

        for(int i=0;i<m;i++){
            res.add(intervals[i]);
        }
        if(res.size()==0||res.getLast()[1]<newInterval[0]){
            res.add(newInterval);
        }else{
            res.getLast()[1] = Math.max(res.getLast()[1],newInterval[1]);
        }

        for(int i=m;i<intervals.length;i++){
            if(res.getLast()[1]<intervals[i][0]){
                res.add(intervals[i]);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1],intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int binarySearch(int[][] intervals,int target){
        int l=0,r=intervals.length;
        while(l<r){
            int m=(l+r)/2;
            if(intervals[m][0]<target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }

}
