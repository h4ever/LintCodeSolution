package solutions.array;

import java.util.Arrays;

public class RotateMatrix {
    /*
    1   2  3  4
    5   6  7  8
    9  10 11 12
    13 14 15 16
    ->
    13  9 5 1
    14 10 6 2
    15 11 7 3
    16 12 8 4
     */
    public static void rotate(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int left = layer;
            int right = n - 1 - layer;
            for(int up = left; up < right; up++){
                int down = n - 1 - up ;

                int leftUp = matrix[left][up];

                matrix[left][up] = matrix[down][left];
                matrix[down][left] = matrix[right][down];
                matrix[right][down] = matrix[up][right];
                matrix[up][right] = leftUp;


            }

        }
    }

    public static void rotateR(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int left = layer;
            int right = n - 1 - layer;
            for(int up = left; up < right; up++){
                int down = n - 1 - up ;

                int leftUp = matrix[left][up];

                matrix[left][up] = matrix[up][right];
                matrix[up][right] = matrix[right][down];
                matrix[right][down] = matrix[down][left];
                matrix[down][left] = leftUp;
            }

        }
    }

    public static void reverseUpToDown(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }

    public static void reverseLeftToRight(int[][] matrix){
        int n = matrix.length;
        for(int j = 0; j < n/2; j++){
            for(int i = 0; i < n; i++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }


    public static void swap(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        swap(matrix);
        reverseLeftToRight(matrix);
        for(int j=0;j<4;j++){
            System.out.println(Arrays.toString(matrix[j]));
        }

    }
}

