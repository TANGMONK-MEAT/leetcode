package com.github.tangmonkmeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/17 下午4:55
 */
public class 顺时针螺旋顺序 {

    public static void main(String[] args) {
        int[] ints = SpiralMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14, 15},
                {16,17,18,19, 20},
                {21,22,23,24,25}});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型一维数组
     */
    public static int[] SpiralMatrix(int[][] matrix) {
        int len = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(len);
        int size = 0;
        int i = 0;
        int j = 0;
        int ap = 0;
        while (size < len) {
            i = ap;
            j = ap;
            for (; j < matrix[i].length - ap && size < len; j++) {
                res.add(matrix[i][j]);
                size++;
            }
            for (j = j - 1,i++; i < matrix.length - ap && size < len; i++) {
                res.add(matrix[i][j]);
                size++;
            }
            for (i = i - 1,j--; j >= ap && size < len; j--) {
                res.add(matrix[i][j]);
                size++;
            }
            for (j = j + 1,i--; i > ap && size < len; i--) {
                res.add(matrix[i][j]);
                size++;
            }
            ap++;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
