package main.java.solutions.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist1346 {
    /*
    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

     */

    public static  boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int x:arr){
            if(seen.contains(x*2)||(x%2==0&&seen.contains(x/2))) return true;
            seen.add(x);
        }
        return false;
    }


    public static  boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        int m=0;
        for(;m<arr.length&&arr[m]<0;m++);

        for(int i=0;i<m;i++){
            if(arr[i]%2==0){
                int target = arr[i]/2;
                int idx = binarySearch(arr,i+1,m,target);
                if(idx<arr.length&&arr[idx]==target) return true;
            }

        }

        for(int i=m;i<arr.length;i++){
            int target = arr[i]*2;
            int idx = binarySearch(arr,i+1,arr.length,target);
            if(idx<arr.length&&arr[idx]==target) return true;
        }

        return false;

    }

    public static int binarySearch(int[] arr,int lo, int ro, int target){
        if(lo >= ro) return lo;
        int l=lo;
        int r= ro;
        while(l<r){
            int m = l+(r-l)/2;
            if(arr[m]<target){
                l=m+1;
            }else{
                r = m;
            }
        }

        return l;
    }
    public static  boolean checkIfExist3(int[] arr) {
        Arrays.sort(arr);
        int m=0;
        for(;m<arr.length&&arr[m]<0;m++);

        for(int i=0;i<m;i++){
            if(arr[i]%2==0){
                if(binarySearch2(arr,i+1,m-1,arr[i]/2)) return true;
            }

        }
        for(int i=m;i<arr.length;i++){
            if(binarySearch2(arr,i+1,arr.length-1,arr[i]*2)) return true;
        }

        return false;

    }

    public static boolean binarySearch2(int[] arr,int lo, int ro, int target){
        if(lo > ro) return false;
        int l=lo;
        int r= ro;
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m]==target){
                return true;
            }else if(arr[m]<target){
                l=m+1;
            }else{
                r = m-1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //int[] arr = {-16,-13,-2,0,4,5,6,6,6,6,8,9,10};
        //System.out.println(checkIfExist3(arr));
        //System.out.println(binarySearch(arr,0,arr.length,6));
        System.out.println(delPunctuation("abc:"));
    }

    static String  delPunctuation(String word){
        String temp = word;
        if(!Character.isLetter(word.charAt(0)))
            temp = word.substring(1);
        if(!Character.isLetter(word.charAt(word.length()-1)))
            temp = temp.substring(0,temp.length()-1);
        return temp;
    }
}
