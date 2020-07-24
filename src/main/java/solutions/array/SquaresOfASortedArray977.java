package main.java.solutions.array;

public class SquaresOfASortedArray977 {
    /*
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
    Note:

    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.

     */
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i=0,j=A.length-1,p=A.length-1;
        while(i<=j){
            int l = A[i]*A[i];
            int r = A[j]*A[j];
            if(r>l){
                ans[p] = r;
                j--;
            }else{
                ans[p]=l;
                i++;
            }
            p--;
        }
        return ans;
    }
}
