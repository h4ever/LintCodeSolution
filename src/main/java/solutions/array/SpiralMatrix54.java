package solutions.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    /*
    Given an m x n matrix, return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int size = m*n;
        int up=0,down=m-1,left=0,right=n-1;

        while(res.size()<size){
            for(int col=left;col<=right&&res.size()<size;col++){
                res.add(matrix[up][col]);
            }
            for(int row=up+1;row<=down&&res.size()<size;row++){
                res.add(matrix[row][right]);
            }
            for(int col=right-1;col>=left&&res.size()<size;col--){
                res.add(matrix[down][col]);
            }
            for(int row=down-1;row>=up+1&&res.size()<size;row--){
                res.add(matrix[row][left]);
            }
            up++;down--;left++;right--;
        }
        return res;
    }
}
