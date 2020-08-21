package main.java.solutions.array;

import java.math.BigDecimal;
import java.util.Arrays;

public class UniquePaths114 {
    public static BigDecimal factorial(int n){ // x! / y!
        BigDecimal result = new BigDecimal(1);
        BigDecimal a;
        for(int i = 2; i <= n; i++){
         a = new BigDecimal(i);
           result = result.multiply(a);
        }
        return  result;

    }

    public int uniquePaths(int m, int n) {
        // write your code here
        if(m==1||n==1) return 1;
        BigDecimal a = factorial(m+n-2);
        BigDecimal b = factorial(m-1);
        BigDecimal c = factorial(n-1);
        return a.divide(b.multiply(c)).intValue();

    }

    public static int uniquePaths3(int m, int n) {
        int[] cell = new int[n];
        for(int i=0;i<n;i++) cell[i] = 1;
        for(int i=1;i<n;i++){
            cell[i]+= cell[i-1];
        }
        return cell[n-1];
    }


    public static int uniquePaths2(int m, int n) {
        int[][] cell = new int[m][n];
        for(int i=0;i<m;i++) cell[i][0] = 1;
        for(int i=0;i<n;i++) cell[0][i] = 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                cell[i][j] = cell[i-1][j] + cell[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(cell));
        return cell[m-1][n-1];

    }

    public static void main(String[] args) {
        uniquePaths2(4,4);
    }
}
