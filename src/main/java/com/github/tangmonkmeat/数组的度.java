package com.github.tangmonkmeat;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/20 11:06
 */
public class 数组的度 {

    public static void main(String[] args) {

        int res = findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println(res);

    }

    public static int findShortestSubArray(int[] nums) {
        // 记录每一个元素 出现的次数，首次出现的 位置和最后一次出现的次数
        Map<Integer,int[]> map = new HashMap<>();
        // 记录
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],new int[]{1,i,i});
            }else {
                int[] ins = map.get(nums[i]);
                ins[0] = ins[0] + 1;
                ins[2] = i;
            }
        }
        int du = 1;
        int maxLen = 50000;
        for(Map.Entry<Integer,int[]> entry : map.entrySet()){
            int[] value = entry.getValue();
            if (value[0] > du){
                du = value[0];
                maxLen = value[2] - value[1] + 1;
            } else if (value[0] == du){
                maxLen = Math.min(value[2] - value[1] + 1,maxLen);
            }
        }
        return maxLen;
    }
}
