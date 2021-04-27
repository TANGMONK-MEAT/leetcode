package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/12 下午9:08
 */
public class 撕纸条拼接2 {

    public static void main(String[] args) {
        String s1 = "xab";
        String s2 = "xabb";
        String s = "xxabbab";
        int re = getResult(s1.toCharArray(), s2.toCharArray(), s.toCharArray(), 0, 0, 0, 0, 0);
        System.out.println(re);
    }

    static int curr = Integer.MAX_VALUE;
    public static int getResult(char[] s1,char[] s2,char[] s,int i,int j,int k,int count,int who){
        if (k >= s.length){
            return Math.min(curr,count + 1);
        }

        if (i < s1.length && s1[i] == s[k]){
            int res = getResult(s1, s2, s, i + 1, j, k + 1, who == 1 ? count + 1 : count, 0);
            if (res > 0){
                curr = Math.min(res, curr);
                return res;
            }
        }
        if (i == 0 && j == 0){
            who = 1;
        }
        if (j < s2.length && s2[j] == s[k]){
            int res = getResult(s1, s2, s, i , j + 1, k + 1, who == 0 ? count + 1 : count, 1);
            if (res > 0){
                curr = Math.min(res, curr);
                return res;
            }
        }
        return 0;
    }
}
