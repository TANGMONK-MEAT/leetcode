package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午3:26
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3};
        selSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[j] ^ arr[i];
                    arr[j] = arr[j] ^ arr[i];
                }
            }
        }
    }
}
