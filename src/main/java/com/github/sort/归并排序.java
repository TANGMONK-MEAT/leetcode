package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午3:26
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {0,-1,7,6,5,4,3,2,1};
        sort(arr,0,arr.length - 1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r, int[] temp){
        if (l < r){
            int mid = (l + r) / 2;
            sort(arr,l,mid,temp);
            sort(arr,mid + 1,r,temp);
            merge(arr,l,mid,r,temp);
        }
    }

    public static void merge(int[] arr,int l,int mid,int r,int[] temp){
        int i = l;
        int j = mid + 1;
        int index = 0;
        // 归并
        while (i <= mid && j <= r){
            if (arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }
        // 左边子序列剩余的元素
        while (i <= mid){
            temp[index++] = arr[i++];
        }
        // 右边子序列剩余的元素
        while (j <= r){
            temp[index++] = arr[j++];
        }
        System.arraycopy(temp,0,arr,l,r - l + 1);
    }

}
