package com.github.tangmonkmeat;

import java.util.Arrays;
import java.util.Map;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/5/5 下午2:11
 */
public class 删除并获得点数 {

    public static void main(String[] args) {

        System.out.println(new 删除并获得点数().deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));

    }

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
