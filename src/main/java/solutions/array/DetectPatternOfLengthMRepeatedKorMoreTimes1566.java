package solutions.array;

public class DetectPatternOfLengthMRepeatedKorMoreTimes1566 {
    /*
    Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.

A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
     */
    public static boolean containsPattern(int[] arr, int m, int k) {
        if(m*k>arr.length) return false;
        int[] pattern = new int[m];
        for(int i=0;i<arr.length-m*k+1;i++){
            for(int j=0;j<m;j++){
                pattern[j] = arr[i+j];
            }
            int q=0;
            for(;q<(k-1)*m&&(i+m+q)<arr.length;q++){
                if(pattern[q%m]!=arr[i+m+q]) break;
            }
            if(q==(k-1)*m) return true;
        }
        return false;
    }

    public boolean containsPattern2(int[] arr, int m, int k) {
        for(int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,3};
        boolean x = containsPattern(arr,2,3);
        System.out.println(x);
    }
}
