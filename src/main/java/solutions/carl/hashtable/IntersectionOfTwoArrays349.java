package solutions.carl.hashtable;

import java.util.*;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        Iterator<Integer> iterator = set1.iterator();
        int i=0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if(set1.contains(i)){
                set2.add(i);
            }
        }

        return set2.stream().mapToInt(x->x).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        int[] set1 = new int[1001];
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1[i] = 1;
        }
        for (int i : nums2) {
            if(set1[i] != 0){
                set2.add(i);
            }
        }

        return set2.stream().mapToInt(x->x).toArray();
    }

}
