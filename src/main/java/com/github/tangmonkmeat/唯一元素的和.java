package com.github.tangmonkmeat;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/6 22:36
 */
public class 唯一元素的和 {

    public static void main(String[] args) {

        int sum = sumOfUnique(new int[]{10,6,9,6,9,6,8,7});
        System.out.println(sum);

    }

    public static int sumOfUnique(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        int res = 0;
        // 排序
        Arrays.sort(nums);
        for (int i = 0;i < len;i++){
            if (i == 0 && nums[i] != nums[i + 1]){
                res += nums[i];
            }
            else if (i == len - 1 && nums[i] != nums[i - 1]){
                res += nums[i];
            }
            else if (i > 0 && i < len - 1 && nums[i] == nums[i - 1] && nums[i] == nums[i + 1]){
                res += nums[i];
            }
        }
        return res;
    }

}
