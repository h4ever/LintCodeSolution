package solutions.array;

import java.util.*;

public class Shift2DGrid1260 {
    public static void shiftGrid1Step(int[][] grid){
        int m = grid.length;
        int n= grid[0].length;
        int[] lastCol = new int[m];
        for(int i=0;i<m;i++){
            lastCol[i]=grid[i][n-1];
        }
        for(int c=n-1;c>0;c--){
            for(int r=0;r<m;r++){
                grid[r][c] = grid[r][c-1];
            }
        }
        for(int r=1;r<m;r++){
            grid[r][0] = lastCol[r-1];
        }
        grid[0][0] = lastCol[m-1];
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                q.offer(grid[i][j]);
            }
        }
        k %= (m*n);
        while(k-->0) q.offerFirst(q.pollLast());
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int i=n;
            while(i-->0) row.add(q.pollFirst());
            res.add(row);
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        shiftGrid1Step(grid);
    }
}
