package com.github.tangmonkmeat;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/10 13:58
 */
public class 零1矩阵 {

    public static void main(String[] args) {

        int[][] res = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int r = matrix.length;
        int l = matrix[0].length;

        int[][] dist = new int[r][l];

        //初始化
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist[i], 666);
        }

        // 1. 从上到下，从左到右遍历矩阵
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        // 从下到上，从右到左遍历
        for (int i = r - 1; i >= 0; --i) {
            for (int j = l - 1; j >= 0; --j) {
                if (i < r - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j < l - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }
}
