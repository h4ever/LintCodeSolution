package main.java.solutions.array;

public class MonotonicArray896 {
    /*
    An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.
Note:

    1 <= A.length <= 50000
    -100000 <= A[i] <= 100000

     */
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if(len==1) return true;
        boolean decreasing = false, increasing =false;
        if(A[0]<=A[len-1])  increasing=true;
        else decreasing=true;
        for(int i =1;i<len;i++){
            if(A[i-1]>A[i]&&increasing) return false;
            if(A[i-1]<A[i]&&decreasing) return false;
        }
        return true;
    }

    public boolean isMonotonic2(int[] A) {
        boolean dec = false;
        boolean inc = false;
        for(int i=1;i<A.length;i++){
            if(A[i-1]<A[i]){
                inc = true;
            }
            if(A[i-1]>A[i]){
                dec = true;
            }
        }
        return dec&&inc ? false:true;
    }
}
