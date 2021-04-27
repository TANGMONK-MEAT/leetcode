package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/24 上午11:16
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {5,2,4,3,6,0};
        qSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qSort(int[] arr,int l,int r){
        if (l < r){
            // 子序列的第一个字符为基准
            int x = arr[l];
            int i = l;
            int j = r;
            while (i < j){
                while (i < j && arr[j] >= x){
                    j--;
                }
                if (i < j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] <= x){
                    i++;
                }
                if (i < j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[j] = x;
            qSort(arr,l,j - 1);
            qSort(arr,j + 1, r);
        }
    }

}
