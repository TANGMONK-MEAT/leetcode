package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/17 下午5:46
 */
public class 包含的最长连续子数组的长度 {

    public static void main(String[] args) {
        System.out.println(GetMaxConsecutiveOnes(new int[]{0,0},2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组
     * @param k int整型 允许0变为1的个数
     * @return int整型
     */
    static int max = 0;
    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        getMaxOne(arr,0,k);
        return max;
    }

    public static void getMaxOne(int[] arr,int index,int k){
        if (k == 0 || index == arr.length){
            int len = 0;
            // 统计
            for (int v : arr) {
                if (v == 1) {
                    len++;
                    max = Math.max(max, len);
                } else {
                    len = 0;
                }
            }
            return;
        }
        // 回朔
        for (int j = index; j < arr.length; j++) {
            if (arr[j] == 0){
                arr[j] = 1;
                getMaxOne(arr,index + 1,k - 1);
                arr[j] = 0;
            }
        }
    }
}
