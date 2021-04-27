package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/17 下午4:44
 */
public class 所有碎片的平均长度 {

    public static void main(String[] args) {
        int aaabbaaac = GetFragment("abbccc");
        System.out.println(aaabbaaac);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return int整型
     */
    public static int GetFragment (String str) {
        if ("".equals(str)){
            return 0;
        }
        int sum = 0;
        int size = 0;
        char[] cs = str.toCharArray();
        int j = 0;
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] != cs[i + 1]){
                size++;
                sum += i - j + 1;
                j = i + 1;
            }
        }
        sum += cs.length - j;
        size++;
        return sum / size;
    }
}
