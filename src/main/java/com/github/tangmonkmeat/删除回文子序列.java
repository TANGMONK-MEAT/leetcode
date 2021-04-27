package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/15 下午2:21
 */
public class 删除回文子序列 {

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("abab"));
    }

    // abbab 2
    // abb 2
    // abaaab 3
    public static int removePalindromeSub(String s) {
        if ("".equals(s)){
            return 0;
        }
        char[] v1 = s.substring(0, s.length() / 2).toCharArray();
        char[] v2 = s.substring(s.length() / 2).toCharArray();
        for (int i = 0; i <= v1.length - 1; i++) {
            if (v1[i] != v2[v2.length - 1 - i]){
                return 2;
            }
        }
        return 1;
    }
}
