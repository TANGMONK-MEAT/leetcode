package com.github.tangmonkmeat;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl 
 * @date 2021/2/25 下午12:07
 * @version 1.0
 */
public class 转置矩阵 {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));

    }


    public static int[][] transpose(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        // if(n == m){
        //     int temp;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i + 1; j < m; j++) {
        //             temp = matrix[j][i];
        //             matrix[j][i] = matrix[i][j];
        //             matrix[i][j] = temp;
        //         }
        //     }
        //     return matrix;
        // }
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

}
