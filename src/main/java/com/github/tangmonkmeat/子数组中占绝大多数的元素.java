package com.github.tangmonkmeat;

import java.util.*;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/4 20:55
 */
public class 子数组中占绝大多数的元素 {

    int[] nums;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer>[] lists = new ArrayList[20001];
    List<ArrayList<Integer>> counter = new ArrayList<>();
    int[] temp;

    public static void main(String[] args) {

        String[] strs = new String[10];

        strs[1] = "123";

        System.out.println(strs[0]);

        // int[] arr = new int[]{1,1,2,2,1,1};
        // System.out.println(new 子数组中占绝大多数的元素(arr).query(0,5,4));
        // System.out.println(Arrays.binarySearch(new int[]{-2,2,3}, 0));
    }

    public 子数组中占绝大多数的元素(int[] arr) {
        nums = arr;

        for (int i = 0; i < arr.length; i++) {
            if (lists[nums[i]] == null) {
                lists[nums[i]] = new ArrayList<>();
                lists[nums[i]].add(-1 * nums[i]);
                counter.add(lists[nums[i]]);
            }
            lists[nums[i]].add(i);

        }
        counter.sort(Comparator.comparingInt(ArrayList::size));
        temp = new int[counter.size()];
        for (int i = 0; i < counter.size(); i++) {
            temp[i] = counter.get(i).size();
        }
        System.out.println();
    }

    public int query(int left, int right, int threshold) {

        if (right - left <= 50) {

            map.clear();

            for (int i = left; i <= right; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) >= threshold) {
                    return nums[i];
                }
            }
            return -1;
        } else {
            int pos = Arrays.binarySearch(temp, threshold - 1);
            if (pos < 0) {
                pos = -1 * pos - 1;
            }

            for (int i = pos; i < counter.size(); i++) {
                // 二分法 计算  个数 为 5 的元素的索引 的个数
                // 同时，必须满足，元素的索引值 >= left
                int s = Collections.binarySearch(counter.get(i), left);
                // 设置，刚好比 left 大的元素的索引
                // 因此，s 最小就为 0，最大 就是 counter.get(i).size()
                if (s < 0) {
                    s = -1 * s - 1;
                }
                // 二分法 计算  个数 为 5 的元素的索引 的个数
                // 同时，必须满足，元素的索引值 >= left
                int e = Collections.binarySearch(counter.get(i), right);
                if (e < 0) {
                    e= -1 * e - 1;
                }
                if (e - s + 1 >= threshold) {
                    return counter.get(i).get(0) * -1;
                }
            }
            return -1;
        }

    }

}
