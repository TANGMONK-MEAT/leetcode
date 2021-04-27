package com.github.tangmonkmeat;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/23 下午3:34
 */
public class 幸运概率 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(new 幸运概率().getProb(n));
    }

    static int fun1(int i) {
        return i <= 1 ? 1 : fun1(i - 1) + fun1(i - 3);
    }


    public String getProb(int n){
        DecimalFormat format = new DecimalFormat("#0.000000");
        int ins = 0;
        if (n > 10){
            ins = n - 10;
        }
        double a = 1;
        for (int i = ins; i < n; i++) {
            a = a * (1000 - i);
        }
        double a1 = 1;
        for (int i = ins; i < n; i++) {
            a1 = a1 * (990 - i);
        }
        return format.format(1 - (a1 / a));
    }
}
