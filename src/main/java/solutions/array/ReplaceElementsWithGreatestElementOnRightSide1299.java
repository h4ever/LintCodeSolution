package solutions.array;

public class ReplaceElementsWithGreatestElementOnRightSide1299 {
    /*
    Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
     */
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len-1];
        arr[len-1] = -1;
        for(int i=len-2;i>=0;i--){
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp,max);
        }
        return arr;
    }
}
