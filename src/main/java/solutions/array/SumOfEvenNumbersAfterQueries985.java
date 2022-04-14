package solutions.array;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries985 {
    /*
    We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
Note:

    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    1 <= queries.length <= 10000
    -10000 <= queries[i][0] <= 10000
    0 <= queries[i][1] < A.length

     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            A[queries[i][1]] += queries[i][0];
            int evenSum = 0;
            for(int j=0;j<A.length;j++){
                if(A[j]%2==0) evenSum += A[j];
            }
            ans[i] = evenSum;
        }
        return ans;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int evenSum = 0;
        for(int i=0;i<A.length;i++) if(A[i]%2==0) evenSum+=A[i];
        for(int i=0;i<queries.length;i++){
            int val = queries[i][0];
            int oldVal = A[queries[i][1]];
            int newVal = oldVal+val;
            if(oldVal%2==0&&val%2==0){
                evenSum +=val;
            }else if(oldVal%2==0&&val%2!=0){
                evenSum -= oldVal;
            }else if(oldVal%2!=0&&val%2!=0){
                evenSum +=newVal;
            }
            A[queries[i][1]] = newVal;
            ans[i] = evenSum;
        }
        return ans;
    }
}
