package main.java.solutions.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits1356 {
    /*
    Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the sorted array.
     */
    public static int[] sortByBits(int[] arr) {
        Comparator<Integer> rule =  Comparator.comparingInt((Integer i) -> Integer.bitCount(i) ).thenComparingInt(i->i);
        return Arrays.stream(arr).boxed().sorted(rule).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
            int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));

    }

}
