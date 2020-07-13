package main.java.solutions.array;

import java.util.Arrays;

public class Missing268Number {
    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return n*(n+1)/2 - Arrays.stream(nums).sum();
    }
}
