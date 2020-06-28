package main.java.solutions.math;

public class LargestTimeForGivenDigits949 {
    /*
    Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
     */

    //note this permutations solution
   //9ms
    public String largestTimeFromDigits(int[] A) {
        int largestTime = -1;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) continue;
                    int result = largestTimeHelper(A[i], A[j], A[k], A[6-i-j-k]);
                    largestTime = Math.max(result, largestTime);
                }
            }
        }
        return largestTime==-1?"":String.format("%2d:%2d",largestTime/60,largestTime%60).replaceAll("\\s","0");
    }

    public int largestTimeHelper(int a, int b, int c, int d) {
        int hours = a * 10 + b;
        int min = c * 10 + d;
        if (hours < 24 && min < 60) {
            return hours * 60 + min;
        }
        return -1;
    }
}
