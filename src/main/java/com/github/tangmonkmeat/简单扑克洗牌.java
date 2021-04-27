package com.github.tangmonkmeat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/9 下午4:25
 */
public class 简单扑克洗牌 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        int[] resultList = getResultList(n, m, list);
        for (int i : resultList){
            System.out.print(i + " ");
        }
    }

    public static int[] getResultList(int n, int m, int[] list){
        int mid = n / 2;
        int[] temp = new int[n];
        if (n % 2 != 0){
            temp[n - 1] = list[n - 1];
        }
        for (int j = 0; j < m; j++) {
            int z = 0;
            for (int i = 0; i < mid; i++) {
                temp[z] = list[mid + i];
                temp[z + 1] = list[i];
                z += 2;
            }
            System.arraycopy(temp,0,list,0,n);
        }
        return list;
    }
}
