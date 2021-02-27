package main.java.solutions;

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
012.3

        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateR(matrix,4);
        for(int j=0;j<4;j++){
            System.out.println(Arrays.toString(matrix[j]));
        }
        System.out.println();
    }
}

