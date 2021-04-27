package com.github.tangmonkmeat;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/19 17:25
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {

        int max = threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(max);

    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        out: for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len -1;
            while (left < right){
                int now = nums[i] + nums[left] + nums[right];
                if (Math.abs(now - target) < Math.abs(result - target)){
                    result = now;
                }
                if (now > target){
                    right--;
                    // 解决nums[right]重复
                    while(left != right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(now < target){
                    left++;
                    // 解决nums[left]重复
                    while(left != right && nums[left] == nums[left-1]){
                        left++;
                    }
                }else {
                    break out;
                }
            }
        }
        return result;
    }

}
