package com.github.tangmonkmeat;

import java.util.Scanner;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/14 上午11:22
 */
public class 计算N阶乘得数后面的0的个数 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int zeroNumber = new 计算N阶乘得数后面的0的个数().getZeroNumber(1000);
        System.out.println(zeroNumber);

        String str = "0000000000\n" +
                "000000000000000000000000000000000000000000000000000000000000\n" +
                "00000000000000000000000000000";

        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars){
            if (c == '0'){
                count++;
            }
        }
        System.out.println(count);
    }
    
    public int getZeroNumber(int n){
        int count = 0;
        for (int i = n; i > 0;) {
            i = i / 5;
            count += i;
        }
        return count;
    }
}
