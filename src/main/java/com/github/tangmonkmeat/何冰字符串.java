package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/21 10:57
 */
public class 何冰字符串 {

    public static void main(String[] args) {

        String s = mergeAlternately("123011111", "456");
        System.out.println(s);



    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            builder.append(chars1[i]).append(chars2[i]);
        }
        if(chars1.length > len){
            builder.append(word1, len, chars1.length);
        }
        if (chars2.length > len){
            builder.append(word2, len, chars2.length);
        }
        return builder.toString();
    }

}
