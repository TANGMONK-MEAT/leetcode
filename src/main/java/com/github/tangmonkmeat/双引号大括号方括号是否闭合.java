package com.github.tangmonkmeat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/14 下午4:10
 */
public class 双引号大括号方括号是否闭合 {

    public static void main(String[] args) {

        System.out.println(new 双引号大括号方括号是否闭合().isClose("1[]2[23{{(23)32}32}]3232]"));
    }

    public boolean isClose(String s){
        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        Map<Character,Character> map = new HashMap<Character,Character>(){
            {
                put('[',']');
                put('(',')');
                put('{','}');
            }
        };
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                list.addFirst(aChar);
            } else if (map.containsValue(aChar)) {
                if (list.isEmpty() || map.get(list.removeFirst()) != aChar) {
                    return false;
                }
            }
        }
        return list.size() == 0;
    }

}
