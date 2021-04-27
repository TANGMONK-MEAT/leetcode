package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/23 下午2:54
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,4,1,3,1,3};
        System.out.println(new 只出现一次的数字().singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res ^= n;
        }
        return res;
    }
}
