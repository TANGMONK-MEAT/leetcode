package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午3:26
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        //shellSort(arr);
        shSort(arr,arr.length / 2);
        System.out.println("最终结果：" + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while (gap > 0){
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < arr.length; j+=gap) {
                    int x = arr[j];
                    int l = j - gap;
                    for (; l >= 0 && arr[l] > x; l-=gap) {
                        arr[l + gap] = arr[l];
                    }
                    arr[l + gap] = x;
                }
            }
            System.out.println("gap=" + gap +", " + Arrays.toString(arr));
            gap = gap / 2;
        }
    }

    public static void shSort(int[] arr,int gap){
        if (gap <= 0){
            return;
        }
        for (int i = 0; i < gap; i++) {
            for (int j = i; j < arr.length; j += gap) {
                int x = arr[j];
                int l = j - gap;
                for (; l >= 0 && arr[l] > x; l -= gap) {
                    arr[l + gap] = arr[l];
                }
                arr[l + gap] = x;
            }
        }
        System.out.println("gap=" + gap +", " + Arrays.toString(arr));
        shSort(arr,gap / 2);
    }
}
