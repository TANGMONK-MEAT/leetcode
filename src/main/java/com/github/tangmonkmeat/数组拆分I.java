package com.github.tangmonkmeat;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/16 16:15
 */
public class 数组拆分I {

    public static void main(String[] args) {
        for (int i = 0;i < 10;i++){
            System.out.println(i + ", " + (i & 1) + ", " + (i % 2));
        }
    }


    public static int arrayPairSum(int[] nums) {
        // 排序(小—>大)
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            if ((i & 1) == 0){
                sum += nums[i];
            }
        }
        return sum;
    }
}
