package com.github.tangmonkmeat;

import java.util.LinkedList;

/**
 * Description: 模拟队列
 *
 * @author zwl
 * @version 1.0
 * @date 2021/4/19 上午8:28
 */
public class Queue<E> {

    private final LinkedList<E> s1;

    private final LinkedList<E> s2;

    public Queue(){
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(E data){
        if (data != null){
            s1.push(data);
        }
    }

    public E pop(){
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
