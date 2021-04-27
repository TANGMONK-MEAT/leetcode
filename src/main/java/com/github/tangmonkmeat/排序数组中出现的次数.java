package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/13 下午7:54
 */
public class 排序数组中出现的次数 {

    public static void main(String[] args) {
        排序数组中出现的次数 t = new 排序数组中出现的次数();
        int[] arr = new int[]{0,2,2,2,4};
        int target = 3;
        System.out.println(t.search3(arr,target + 1) - t.search3(arr,target));
    }

    //public int search(int[] nums, int target) {
    //    if (nums.length <= 0 || target > nums[nums.length - 1] || target < nums[0]){
    //        return 0;
    //    }
    //    if (nums.length == 1){
    //        return nums[0] == target ? 1 : 0;
    //    }
    //    int start = 0,end = nums.length - 1;
    //    int count = 0;
    //    int mid;
    //    while(true){
    //        mid = (start + end) / 2;
    //        if(end - start + 1 == 2){
    //            if (nums[start] != target && nums[end] !=target){
    //                mid = -1;
    //            }
    //            break;
    //        }
    //        if(nums[mid] < target){
    //            start = mid;
    //        }else if(nums[mid] > target){
    //            end = mid;
    //        }else{
    //            break;
    //        }
    //    }
    //    if(mid != -1){
    //        start = mid;
    //        end = mid + 1;
    //        boolean a = false,b = false;
    //        while(start >= 0 || end < nums.length || !a || !b){
    //            if (start >= 0 && nums[start] == target){
    //                count++;
    //            }else {
    //                a = true;
    //            }
    //            start--;
    //            if (end < nums.length && nums[end] == target){
    //                count++;
    //            }else {
    //                b = true;
    //            }
    //            end++;
    //        }
    //    }
    //    return count;
    //}

    //public int search2(int[] nums, int target) {
    //    if (nums.length == 1){
    //        return nums[0] == target ? 1 : 0;
    //    }
    //    int count = 0;
    //    int start = 0, end = nums.length - 1;
    //    while (start <= end){
    //        if (nums[start] == target){
    //            count++;
    //        }
    //        start++;
    //        if (start > end){
    //            break;
    //        }
    //        if (nums[end] == target){
    //            count++;
    //        }
    //        end--;
    //    }
    //    return count;
    //}

    /**
     * 二分查找（特殊情况：查找值不在数组中或者查找的值有重复出现）
     *
     * 1 如果查找的值在数组中，并且查找的值在数组中重复，那么查找的结果是最右端的值；
     * 2 如果查找的值不包含在数组中
     *      1 如果值在中间，那么最后查找的值一定是比 这个值稍大的结果
     *      2 如果值小于数组的最右端（即，小于数组的最小值），那么找到的值还是比这个值大的结果（即，nums[0]）
     *      3 如果值大于数组的最左端（即，大于数组的最大值），那么找到的值就会是 nums[nums.length - 1]
     *
     *因此，查找值在数组中的重复次数
     *      1 查找指定值，在数组中最小值的索引，然后，在查找查找比查找值稍大一点的值的索引，
     *          最后的差值就是重复的次数。
     */
    public int search3(int[] nums, int target){
        int l = 0,r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }


}
