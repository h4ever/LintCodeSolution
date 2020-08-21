package main.java.solutions.array;

public class CountNegativeNumbersInASortedMatrix1351 {
    /*
    Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

Return the number of negative numbers in grid.
     */
    public static int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int r=m-1;
        int c=0;
        int ans = 0;
        while(r>=0&&c<n){
            if(grid[r][c]<0){
                ans += n-c;
                r--;
            }else{
                c++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{ 4, 3, 2,-1},
                        { 3, 2, 1,-1},
                        { 1, 1,-1,-2},
                        {-1,-1,-2,-3}};

        countNegatives(grid);
    }
}
