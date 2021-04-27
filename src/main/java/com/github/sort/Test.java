package com.github.sort;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/15 上午9:07
 */
public class Test {




    public static void main(String[] args) throws InterruptedException {
        //
        //BlockingQueue<Integer> t = new ArrayBlockingQueue<Integer>(1);
        //// 队列填满
        //t.put(1);
        //new Thread(() -> {
        //    try {
        //        TimeUnit.SECONDS.sleep(3);
        //        t.put(3);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        ////
        //t.put(2);
        //
        //t.take();

        //Thread mainThread = Thread.currentThread();
        // 唤醒主线程
        //LockSupport.unpark(mainThread);

        //new Thread(() ->{
        //    try {
        //        System.out.println("start waiting");
        //        TimeUnit.SECONDS.sleep(3);
        //        System.out.println("wait over");
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    } finally {
        //        // 唤醒主线程
        //        LockSupport.unpark(mainThread);
        //    }
        //}).start();
        //// 阻塞主线程
        //LockSupport.park();
        new Test();
    }

}
