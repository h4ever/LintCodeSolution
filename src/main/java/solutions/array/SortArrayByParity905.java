package main.java.solutions.array;

public class SortArrayByParity905 {
    /*
    Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.
Note:

    1 <= A.length <= 5000
    0 <= A[i] <= 5000

     */
    public int[] sortArrayByParity(int[] A) {
        int i=0 , j = A.length-1;
        while(i<j){
            if(A[i]%2==0) {
                i++;continue;
            }
            if(A[j]%2!=0) {
                j--;continue;
            }
            int tmp = A[i];
            A[i++] = A[j];
            A[j--] = tmp;
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i=0 , j = A.length-1;
        while(i<j){
            while(i<A.length&&A[i]%2==0) i++;
            while(j>=0&&A[j]%2!=0) j--;
            if(i<A.length&&j>=0&&i<j){
                int tmp = A[i];
                A[i++] = A[j];
                A[j--] = tmp;
            }

        }
        return A;
    }
    //see also RemoveDuplicatesFromSortedArray26  & RemoveElement27 &  MoveZeroes283
    public int[] sortArrayByParity3(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}
