package solutions.stack;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations1441 {
    /*
    Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

    Push: Read a new element from the beginning list, and push it in the array.
    Pop: delete the last element of the array.
    If the target array is already built, stop reading more elements.

You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.
Constraints:

    1 <= target.length <= 100
    1 <= target[i] <= 100
    1 <= n <= 100
    target is strictly increasing.
     */
    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int max = target[target.length-1];
        max = Math.min(max,n);
        for(int i=0,p=1;p<=max;i++,p++){
            if(target[i]==p){
                ans.add("Push");
            }else{
                ans.add("Push");
                ans.add("Pop");
                i--;
            }
        }
        return ans;
    }

    public static List<String> buildArray2(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for(int i=0,p=1;p<=n&&i<target.length;p++){
            ans.add("Push");
            if(target[i]==p){
                i++;
            }else{
                ans.add("Pop");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] target = {1,2};
        buildArray(target,4);
    }
}
