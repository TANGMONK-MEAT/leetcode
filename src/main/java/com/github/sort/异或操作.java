package com.github.sort;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/25 下午3:14
 */
public class 异或操作 {

    // 相同为0，不同为1

    public static void main(String[] args) {
        int a = -1;
        int b = 1;
        System.out.println(a + ", " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }
}
