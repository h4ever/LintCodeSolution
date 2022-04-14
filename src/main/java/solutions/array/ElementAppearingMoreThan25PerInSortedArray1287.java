package solutions.array;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than
25% of the time.

Return that integer.
 */
public class ElementAppearingMoreThan25PerInSortedArray1287 {
    public static int findSpecialInteger(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(arr[n/4]);list.add(arr[n/2]);list.add(arr[3*n/4]);
        for(int target:list){
            int firstIdx = lowerBound(arr,target);
            int lastIdx = upperBound(arr,target);
            System.out.println("target:"+target+" firstIdx:"+firstIdx+" lastIdx:" +lastIdx);
            if(lastIdx-firstIdx+1>n/4) return target;
        }
        return -1;
    }

    public static int findSpecialInteger2(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(arr[n/4]);list.add(arr[n/2]);list.add(arr[3*n/4]);
        for(int target:list){
            int firstIdx = lowerBound(arr,target);
            if(arr[firstIdx+n/4]==target) return target;
        }
        return -1;
    }

    public static int findSpecialInteger3(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int possibleAns1 = arr[n/4];
        int possibleAns2 = arr[n/2];
        int possibleAns3 = arr[3*n/4];
        int start1,start2,start3;
        for(start1=n/4;start1>=0&&arr[start1]==possibleAns1;start1--);
        System.out.println("start1:"+start1);
        if(arr[start1+n/4+1]==possibleAns1) return possibleAns1;

        for(start2=n/2;start2>n/4&&arr[start2]==possibleAns2;start2--);
        System.out.println("start2:"+start2);
        if(arr[start2+n/4+1]==possibleAns2) return possibleAns2;

        for(start3=3*n/4;start3>n/2&&arr[start3]==possibleAns3;start3--);
        System.out.println("start3:"+start3);
        if(arr[start3+n/4+1]==possibleAns3) return possibleAns3;
        return -1;
    }

    public static int lowerBound(int[] arr,int target){
        int l=0;
        int r=arr.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(arr[m]<target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }

    public static int upperBound(int[] arr,int target){
        int l=0;
        int r=arr.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(arr[m]<=target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        System.out.println(findSpecialInteger3(arr));
    }
}
