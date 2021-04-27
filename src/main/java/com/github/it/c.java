package com.github.it;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/10 下午2:50
 */
public class c extends b {

    @Override
    public void test(){
        System.out.println("---c---");
        super.test();
    }

    @Override
    public void impl(){
        System.out.println("c");
    }

}
