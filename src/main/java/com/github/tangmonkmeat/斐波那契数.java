package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/7 11:32
 */
public class 斐波那契数 {

    public static void main(String[] args) {

        int res = fib(3);
        System.out.println(res);

    }

    public static int fib(int n) {
        if (n <= 1){
            return n;
        }
        int f1 = 0, f2 = 1;
        int fn = 0;
        for (int i = 2;i <= n;i++){
            // f3
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

}
