package solutions.carl.array;

public class SortedSquares977 {
    public int[] sortedSquares(int[] nums){
        int i=0,j=nums.length-1;
        int p=nums.length-1;
        int[] res = new int[nums.length];
        while(i<=j){
            if(nums[i]*nums[i]<nums[j]*nums[j]){
                res[p--] = nums[j]*nums[j];
                j--;
            }else{
                res[p--] = nums[i]*nums[i];
                i++;
            }
        }
        return res;

    }
}
