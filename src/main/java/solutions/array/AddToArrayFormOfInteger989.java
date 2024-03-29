package solutions.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger989 {
    /*
    For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
Note：

    1 <= A.length <= 10000
    0 <= A[i] <= 9
    0 <= K <= 10000
    If A.length > 1, then A[0] != 0

     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        for(int i=A.length-1;i>=0;i--){
            int sum = A[i]+K%10+carry;
            carry = sum/10;
            K = K/10;
            ans.add(sum%10);
        }
        K+=carry;
        while(K>0){
            ans.add(K%10);
            K/=10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
