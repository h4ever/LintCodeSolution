package solutions.array;

public class SpiralMatrixII59 {
    /*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart=0,rowEnd=n-1;
        int colStart=0,colEnd=n-1;
        int num=1;
        while(rowStart<=rowEnd&&colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                res[rowStart][i]=num++;
            }
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++){
                res[i][colEnd]=num++;
            }
            colEnd--;
            for(int i=colEnd;i>=colStart;i--){
                res[rowEnd][i]=num++;
            }
            rowEnd--;
            for(int i=rowEnd;i>=rowStart;i--){
                res[i][colStart]=num++;
            }
            colStart++;
        }
        return res;
    }
}
