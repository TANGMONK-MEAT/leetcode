package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/3 11:47
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {

        System.out.println(search(new int[]{4,5,6,7,0,1,2,3},3));

    }

    // 注意：旋转点必定是在有序数组中
    // 例如：4,5,6,7,0,1,2,3
    // 旋转点： 数组元素中的任意一个

    public static int search(int[] nums, int target) {
        int mid;
        int in1 = 0,in2 = nums.length - 1;
        while (in1 <= in2){
            // 二分
            mid = (in1 + in2) / 2;
            // 情况一
            if (nums[mid] == target){
                return mid;
            }
            // 情况二
            if(nums[mid] >= nums[in1]){
                if (target >= nums[in1] && target <= nums[mid]){
                    in2 = mid - 1;
                }else{
                    in1 = in1 + 1;
                }
            }else{
                if (target >= nums[mid] && target <= nums[in2]){
                    in1 = in1 + 1;
                }else{
                    in2 = in2 - 1;
                }
            }
        }
        return -1;
    }

}
