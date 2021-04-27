package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/9 下午5:17
 */
public class 撕纸条拼接 {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int t = scanner.nextInt();
        //for (int i = 0; i < t; i++) {
        String s1 = "UJvr";
        String s2 = "AWLwqU";
        String s = "AWLwqUJvrU";
        int count = 100;
        if (s1.length() + s2.length() < s.length() || count <= 0) {
            System.out.println(0);
        } else {
            System.out.println(isSuccess(s1.toCharArray(), s2.toCharArray(), s.toCharArray(), count, 0, 0, 0, 0));
        }
    }

    // aa bb abba 3
    // 1
    public static int isSuccess(char[] s1, char[] s2, char[] s, int count, int i, int j, int k, int who) {
        if (count >= 0 && k >= s.length) {
            return 1;
        } else if (count < 0) {
            return 0;
        }
        int res;
        if (i < s1.length && s1[i] == s[k]) {
            res = isSuccess(s1, s2, s, who == 0 ? count : count - 1, i + 1, j, k + 1, 0);
            if (res == 1) {
                return 1;
            }
        }
        if (j < s2.length && s2[j] == s[k]) {
            res = isSuccess(s1, s2, s, who == 1 ? count : count - 1, i, j + 1, k + 1, 1);
            if (res == 1) {
                return 1;
            }
        }
        return 0;
    }
}
