package com.github.tangmonkmeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/2 12:46
 */
public class 较大分组 {

    public static void main(String[] args) {

        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));

    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        int num = 1;
        int n = cs.length;
        for (int i = 0;i < n;i++){
            if (i == n - 1 || cs[i] != cs[i + 1]){
                if (num >= 3){
                    res.add(Arrays.asList(i - num + 1,i));
                }
                num=1;
            }else{
                num++;
            }
        }
        return res;
    }
}
