package com.github.tangmonkmeat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/6 23:18
 */
public class 任意子数组和的绝对值的最大值 {

    public static void main(String[] args) {

        // LinkedList<Integer> l = new LinkedList<>();
        //
        // l.add(1);
        // l.add(2);
        // l.add(3);
        // l.add(4);
        // l.add(5);
        //
        //
        // l.removeLast();
        //
        // System.out.println(Arrays.toString(l.toArray()));

        int amx = new 任意子数组和的绝对值的最大值().maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2});
        System.out.println(amx);
    }


    public int maxAbsoluteSum(int[] nums) {
        // 记录类加过程中的 最值（最大值或者最小值）
        int ans = 0;
        // 记录类加的正数结果
        int sum = 0;
        // 遍历查找最大值（正数）
        for (int value : nums) {
            // 累加
            sum += value;
            // 如果 类加后的结果 < 0
            if (sum < 0) {
                // 重新开始类加
                sum = 0;
            } else {
                // 如果 类加后的 结果 > 0
                // 记录最大值
                ans = Math.max(ans, sum);
            }
        }
        // 重置
        sum = 0;
        // 遍历查找最小值（负数）
        for (int num : nums) {
            sum += num;
            if (sum > 0) {
                sum = 0;
            } else {
                ans = Math.max(ans, -sum);
            }
        }
        return ans;
    }
}
