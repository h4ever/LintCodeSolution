package main.java.solutions.array;

public class DuplicateZeros1089 {
    /*
    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.
Note:

    1 <= arr.length <= 10000
    0 <= arr[i] <= 9

     */
    public void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                for(int j=arr.length-2;j>i;j--){
                    arr[j+1]=arr[j];
                }
                if(i<arr.length-1) arr[++i] = 0;
            }
        }
    }
}
