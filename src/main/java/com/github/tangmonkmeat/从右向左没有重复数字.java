package com.github.tangmonkmeat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/15 下午4:00
 */
public class 从右向左没有重复数字 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String result = getResult(String.valueOf(i));
        System.out.println(result);
    }

    public static String getResult(String s){
        int len = (int)(s.length() / 0.75);
        Map<Character,Integer> map = new HashMap<>(len);
        char[] cs = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (!map.containsKey(cs[i])){
                map.put(cs[i],1);
                str.append(cs[i]);
            }
        }
        return str.toString();
    }
}
