package main.java.solutions.binarysearch;

public class PeakIndexinaMountainArray852 {
    public static int peakIndexInMountainArray(int[] A) {
        int l=0,r=A.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(A[m+1]>A[m]) l=m+1;
            else r=m;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] A = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray(A));
    }
}
