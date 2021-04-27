package com.github.tangmonkmeat;

import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/21 13:06
 */
public class 绝对差不超过限制的最长连续子数组 {

    public static void main(String[] args) {

        int res = longestSubarray2(new int[]{5, 6, 7, 8, 10, 6, 5}, 4);
        System.out.println(res);
    }

    public static int longestSubarray(int[] nums, int limit) {
        int res = 1;
        int start = 0, end = 1;
        while (end < nums.length) {
            if (Math.abs(nums[end] - nums[start]) > limit) {
                res = Math.max(end - start, res);
                while (start < end && Math.abs(nums[start] - nums[end]) > limit) {
                    start++;
                }
                continue;
            }
            out:
            for (int i = start; i < end; i++) {
                for (int j = start + 1; j <= end; j++) {
                    if (Math.abs(nums[i] - nums[j]) > limit) {
                        res = Math.max(j - start, res);
                        start = i + 1;
                        break out;
                    }
                }
            }
            end++;
        }

        return Math.max(res, end - start);
    }

    public static int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int l = 0, r = 0, res = 0;
        while (r < nums.length) {
            while (!maxQueue.isEmpty() && nums[r] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            maxQueue.add(nums[r]);
            while (!minQueue.isEmpty() && nums[r] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            minQueue.add(nums[r]);
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[l]) {
                    maxQueue.remove();
                }
                if (minQueue.peek() == nums[l]) {
                    minQueue.remove();
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
