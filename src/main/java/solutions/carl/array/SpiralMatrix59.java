package solutions.carl.array;

public class SpiralMatrix59 {
    public int[][] generateMatrix(int n){

        /*
        给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
         */
        int[][] ans = new int[n][n];
        int p = 1;
        int l=0,t=0,r=n-1,b=n-1;
        while(p<=n*n){
            for(int i=0;i<=r;i++){
                ans[t][i] = p++;
            }
            t++;
            for(int i=t;i<=b;i++){
                ans[i][r] = p++;
            }
            r--;
            for(int i=r;i>=l;i--){
                ans[b][i] = p++;
            }
            b--;
            for(int i=b;i>=t;i--){
                ans[i][l] = p++;
            }
            l++;
        }
        return ans;

    }
}
