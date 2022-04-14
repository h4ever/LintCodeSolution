package solutions.array;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
Constraints:

    arr1.length, arr2.length <= 1000
    0 <= arr1[i], arr2[i] <= 1000
    Each arr2[i] is distinct.
    Each arr2[i] is in arr1.

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
            while(occurence-->0){
                res[idx++] = x;
            }
            sta1.remove(x);
        }
        Set<Integer> keySet = sta1.keySet();
        for(Integer key : keySet){
            int occurence = sta1.get(key);
            while(occurence-->0){
                res[idx++] = key;
            }
        }
        return res;

    }

}
