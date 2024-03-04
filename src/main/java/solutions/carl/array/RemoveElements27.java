package solutions.carl.array;

public class RemoveElements27 {
    public int removeElements(int[] arr, int target){
        int p = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=target){
                arr[p++] = arr[i];
            }
        }
        return p;
    }
}
