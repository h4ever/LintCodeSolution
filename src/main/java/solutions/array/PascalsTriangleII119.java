package main.java.solutions.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    /*
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){
            ans.add(1);
            for(int j=i-1;j>0;j--){
                ans.set(j,ans.get(j)+ans.get(j-1));
            }
        }
        return ans;
    }
}
