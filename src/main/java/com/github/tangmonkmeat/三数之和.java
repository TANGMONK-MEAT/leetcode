package com.github.tangmonkmeat;

import com.sun.corba.se.spi.ior.TaggedProfileTemplate;

import java.lang.annotation.Target;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/5 17:26
 */
public class 三数之和 {

    public static void main(String[] args) {
        System.out.println(new 三数之和().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    /**
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L]nums[L] 和 nums[R]nums[R]nums[R]，计算三个数的和 sumsumsum 判断是否满足为 000，满足则添加进结果集
     * 如果 nums[i]nums[i]nums[i]大于 000，则三数之和必然无法等于 000，结束循环
     * 如果 nums[i]nums[i]nums[i] == nums[i−1]nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsumsum == 000 时，nums[L]nums[L]nums[L] == nums[L+1]nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++L++
     * 当 sumsumsum == 000 时，nums[R]nums[R]nums[R] == nums[R−1]nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R−−R--R−−
     * 时间复杂度：O(n2)O(n^2)O(n2)，nnn 为数组长度
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3){
            return res;
        }
        // 排序
        Arrays.sort(nums);
        int left,right;
        int total;
        for (int i = 0;i < len;i++){
            //
            if (nums[i] > 0){
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            left = i + 1;
            right = len - 1;
            while (left < right){
                total = nums[i] + nums[left] + nums[right];
                if (total == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重
                    while (left < right){
                        if (nums[left] == nums[left + 1] && nums[right] == nums[right - 1]){
                            left++;
                            right--;
                        }else{
                            break;
                        }
                    }
                    left++;
                    right--;
                }else if (total < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
