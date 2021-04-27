package com.github.tangmonkmeat;

import java.util.*;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/20 11:46
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {

        List<String> list = new 电话号码的字母组合().letterCombinations("2");
        System.out.println(Arrays.toString(list.toArray()));

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, char[]> map = new HashMap<>(digits.length() + 1);
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] cs = digits.toCharArray();
        List<String> res = new ArrayList<>((int) Math.pow(cs.length,cs.length));
        def(res, cs, map,0,new StringBuilder());
        return res;
    }

    public void def(List<String> res, char[] digits, Map<Character, char[]> map, int index, StringBuilder str) {
        if (index >= digits.length){
            res.add(str.toString());
            return;
        }
        char[] chars = map.get(digits[index]);
        for (char aChar : chars) {
            str.append(aChar);
            def(res, digits, map, index + 1, str);
            str.deleteCharAt(index);
        }
    }

}
