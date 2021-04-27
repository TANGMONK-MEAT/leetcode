package com.github.tangmonkmeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/13 上午10:29
 */
public class 差值最小子序列 {

    public static void main(String[] args) {
        //int[] arr = {1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 13};
        //int[] arr = {1, 2};
        int[] arr = {1, 2, 4, 4, 6,8,8,9, 9,13};
        System.out.println(Arrays.toString(new 差值最小子序列().getMinDiffList(arr, 5, -1).toArray()));
    }

    public List<Integer> getMinDiffList(int[] arr, int k, int x) {
        int len = arr.length;
        if (len < k) {
            return new ArrayList<>();
        }
        // x 大于 arr 最大值
        if (x >= arr[len - 1]) {
            List<Integer> res = new ArrayList<>(k);
            for (; k > 0; k--) {
                res.add(arr[len - k]);
            }
            return res;
        }
        // x 小于 arr 最小值
        if (x <= arr[0]) {
            List<Integer> res = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        int start = 0, end = len - 1;
        int mid = -1;
        // 找到一个离 x 最近的最小值 mid
        while (true) {
            // 向下取整
            mid = (end + start) / 2;
            if (end - start + 1 == 2) {
                mid = Math.abs(arr[start] - x) < Math.abs(arr[end] - x) ? start : end;
                break;
            }
            if (arr[mid] > x) {
                end = mid;
            } else if (arr[mid] < x) {
                start = mid;
            } else {
                break;
            }
        }
        start = mid - 1;
        end = mid + 1;
        LinkedList<Integer> result = new LinkedList<>();
        result.add(arr[mid]);
        k--;
        while (k > 0) {
            if (start >= 0 && end < len) {
                if ((Math.abs(arr[start] - x) <= Math.abs(arr[end] - x))) {
                    result.addFirst(arr[start]);
                    start--;
                    k--;
                } else if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                    result.addLast(arr[end]);
                    end++;
                    k--;
                }
            } else if (start < 0) {
                result.addLast(arr[end]);
                end++;
                k--;
            } else {
                result.addFirst(arr[start]);
                start--;
                k--;
            }
        }
        return result;
    }

}
