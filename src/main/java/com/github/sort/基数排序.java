package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/26 上午11:24
 */
public class 基数排序 {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int max = getMaxValue(arr);
        for (int e = 1; max / e > 0; e *= 10) {
            countSort(arr,e);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int getMaxValue(int[] arr){
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static void countSort(int[] arr,int e){
        // 记录出现的次数
        int[] count = new int[10];
        // 储存每次排序的结果，临时数组
        int[] temp = new int[arr.length];

        // 记录次数
        for (int item : arr) {
            count[(item / e) % 10]++;
        }

        // 次数累加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 计算 item 的位置，将arr 排序后的结果copy 到 temp
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = count[(arr[i] / e) % 10];
            temp[index - 1] = arr[i];
            count[index]--;
        }

        // 重置 arr
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}
