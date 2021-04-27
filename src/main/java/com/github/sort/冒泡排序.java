package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午3:00
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,0};
        mpSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mpSort(int[] arr){
        boolean isSwap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    //int temp = arr[j + 1];
                    //arr[j + 1] = arr[j];
                    //arr[j] = temp;
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j + 1] ^ arr[j];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    isSwap = true;
                }
            }
            if (!isSwap){
                break;
            }
        }
    }
}
