package com.github.tangmonkmeat;

import java.util.Scanner;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/15 下午4:21
 */
public class A替换B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char a = in.next().charAt(0);
        char b = in.next().charAt(0);
        System.out.println("Result String:" + getResult(str.toCharArray(),a,b));
        System.out.println("A count:" + count);
    }

    static int count = 0;
    public static String getResult(char[] cs,char a,char b){
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == a){
                cs[i] = b;
                count++;
            }
        }
        return new String(cs);
    }
}
