package com.github.it;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/10 下午2:49
 */
public class b extends a{

    @Override
    public void test(){
        System.out.println("---b---");
        super.test();
    }

    @Override
    public void impl(){
        System.out.println("b");
    }

}
