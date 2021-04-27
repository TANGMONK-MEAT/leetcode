package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/19 19:18
 */
public class 最大连续1的个数III {

    public static void main(String[] args) {
        int longestOnes = longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(longestOnes);
    }

    public static int longestOnes(int[] A, int K) {
        // 连续 1 子区间
        int start = 0, end = 0;
        // 子区间的长度
        int maxLen = 0;
        // 记录当前区间的 0 出现的次数
        int zeroNum = 0;
        while (end < A.length) {
            if (A[end] == 0){
                zeroNum++;
            }
            while (zeroNum > K){
                if (A[start] == 0){
                    zeroNum--;
                }
                start++;
            }
            end++;
            maxLen = Math.max(end - start,maxLen);
        }
        return maxLen;
    }

}
