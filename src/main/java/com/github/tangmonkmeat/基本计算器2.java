package com.github.tangmonkmeat;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/11 下午8:28
 */
public class 基本计算器2 {

    public static int calculate(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> nl = new LinkedList<>();
        LinkedList<Character> yl = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= '0' && array[i] <= '9'){
                int tem0 = array[i] - '0';
                while (i < array.length - 1 && array[i + 1] >= '0' && array[i + 1] <= '9'){
                    tem0 = tem0 * 10 + (array[i + 1] - '0');
                    i++;
                }
                nl.push(tem0);
            }else if (array[i] == '+' || array[i] == '-'){
                yl.push(array[i]);
            }else if(array[i] == '*'){
                i++;
                while (array[i] == ' ') {
                    i++;
                }
                int tem0 = array[i] - '0';
                while (i < array.length - 1 && array[i + 1] >= '0' && array[i + 1] <= '9'){
                    tem0 = tem0 * 10 + (array[i + 1] - '0');
                    i++;
                }
                int tem1 = (nl.pop()) * tem0;
                nl.push(tem1);
            }else if (array[i] == '/'){
                i++;
                while (array[i] == ' ') {
                    i++;
                }
                int tem0 = array[i] - '0';
                while (i < array.length - 1 && array[i + 1] >= '0' && array[i + 1] <= '9'){
                    tem0 = tem0 * 10 + (array[i + 1] - '0');
                    i++;
                }
                int tem2 = (nl.pop()) / tem0;
                nl.push(tem2);
            }
        }
        int x,y;
        while (nl.size() > 1 && yl.size() > 0){
            x = nl.removeLast();
            y = nl.removeLast();
            if (yl.peekLast() == '+'){
                nl.add(x + y);
            }else {
                nl.add(x - y);
            }
            yl.removeLast();
        }
        return nl.peek();
    }

    public static void main(String[] args) {

        System.out.println(calculate("3+5/2"));
    }

}
