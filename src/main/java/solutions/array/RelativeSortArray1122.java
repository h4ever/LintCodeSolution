package main.java.solutions.array;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 */
public class RelativeSortArray1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> sta1 = new TreeMap<>();
        for(int i=0;i<arr1.length;i++){
            sta1.put(arr1[i],sta1.getOrDefault(arr1[i],0)+1);
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        for(int x:arr2){
            int occurence = sta1.get(x);
            while(occurence>0){
                res[idx++] = x;
                occurence--;
            }
            sta1.remove(x);
        }
        Set<Integer> keySet = sta1.keySet();
        for(Integer key : keySet){
            int occurence = sta1.get(key);
            while(occurence>0){
                res[idx++] = key;
                occurence--;
            }
        }
        return res;

    }

}
