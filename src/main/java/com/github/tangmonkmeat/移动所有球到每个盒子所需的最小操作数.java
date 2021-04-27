package com.github.tangmonkmeat;

import java.util.*;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/21 11:15
 */
public class 移动所有球到每个盒子所需的最小操作数 {

    public static void main(String[] args) {

        int[] answer = minOperations("110");
        System.out.println(Arrays.toString(answer));

    }

    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        char[] chars = boxes.toCharArray();
        int[] answer = new int[len];
        int index = 0;
        while (index < len) {
            int count = 0;
            for (int i = boxes.length() - 1; i >= 0; i--) {
                if (i != index && chars[i] == '1') {
                    count += Math.abs(i - index);
                }
            }
            answer[index] = count;
            index++;
        }
        return answer;
    }

}
