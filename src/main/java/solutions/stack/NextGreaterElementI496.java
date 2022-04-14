package solutions.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI496 {
    /*
     You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int p = positionInNums2(nums2,nums1[i]);
            int j = p;
            for(;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){ans[i]=nums2[j];break;}
            }
            if(j==nums2.length) ans[i]=-1;
        }
        return ans;
    }

    public int positionInNums2(int[] nums2,int x){
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==x) return i;
        }
        return nums2.length;
    }

    public static int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    public static void main(String[] args) {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2,5,6,7,10,9,8};
        nextGreaterElement2(findNums,nums);
    }
}
