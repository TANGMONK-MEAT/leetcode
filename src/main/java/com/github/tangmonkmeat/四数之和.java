package com.github.tangmonkmeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/26 上午11:04
 */
public class 四数之和 {

    public static void main(String[] args) {


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return res;
        }
        def(res,new ArrayList<>(4),nums,target,0,4);
        return res;
    }

    public void def(List<List<Integer>> res,List<Integer> one, int[] nums,int target,int index,int n){
        if (n <= 0 && one.size() == 4){
            res.add(one);
        }

        for (int i = 0; i < 4; i++) {

        }
    }
}
