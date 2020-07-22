package main.java.solutions.array;

public class SortArrayByParityII922 {
    /*
    Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.
Note:

    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000

     */
    public static int[] sortArrayByParityII(int[] A) {
        int i=0,j=1;
        while(i<A.length-1&&j<A.length){
            if(A[i]%2==0){
                i+=2;
                continue;
            }
            if(A[j]%2==1){
                j+=2;
                continue;
            }
            swap(A,i,j);
            i+=2;j+=2;
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int e = 0;
        int o = 1;
        while(e < A.length && o < A.length) {
            if(A[e]%2 != 0) {
                swap(A, e, o);
                o += 2;
            } else {
                e += 2;
            }
        }

        return A;
    }

    public static void swap(int[] A ,int i,int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
