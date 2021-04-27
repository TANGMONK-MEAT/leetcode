package com.github.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午2:25
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {0,4,1,7,2,-1,0};
        insertSort(arr);
        System.out.println("最终结果：" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            //int j = i - 1;
            // 查找比 x 小一点或者等于的数
            //for (; j >= 0; j--) {
            //    if (arr[j] <= x){
            //        break;
            //    }
            //}
            //if (j < i - 1){
            //    // 挪动
            //    for (int z = i; z > j + 1; z--) {
            //        arr[z] = arr[z - 1];
            //    }
            //    arr[j + 1] = x;
            //}
            int k = i - 1;
            for (; k >= 0 && arr[k] > x; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = x;

            System.out.println("x=" + x + ", " + Arrays.toString(arr));
        }
    }
}
