package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/23 上午8:48
 */
public class 堆排序 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 6};
        new 堆排序().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {

        // 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length - 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            // 交换 堆顶和堆尾
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;

            // 重新调整堆
            adjustHeap(arr,0,i - 1);
        }
    }


    public void adjustHeap(int[] arr, int i, int lastIndex) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k <= lastIndex; k = 2 * k + 1) {
            if (k + 1 <= lastIndex && arr[k] < arr[k + 1]){
                k++;
            }
            if (arr[k] > arr[i]){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
