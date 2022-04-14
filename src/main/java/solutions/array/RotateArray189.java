package solutions.array;

public class RotateArray189 {
    /*
    Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

    public void rotate2(int[] nums, int k) {
        for(int i=0;i<k%nums.length;i++) {
            rotate1Step(nums);
        }
    }

    public void rotate1Step(int[] nums){
        int last = nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){
            nums[i]=nums[i-1];
        }
        nums[0]=last;
    }

    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int[] oldNums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = oldNums[i];
        }
    }
}
