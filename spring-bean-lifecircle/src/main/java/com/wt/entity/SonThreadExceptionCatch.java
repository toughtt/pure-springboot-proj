package com.wt.entity;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SonThreadExceptionCatch {
    private static int AVAILABLEPROCESSORS = Runtime.getRuntime().availableProcessors();//获取cpu合数

    public static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(AVAILABLEPROCESSORS * 50, AVAILABLEPROCESSORS * 80, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(AVAILABLEPROCESSORS * 2000),
                    new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException {
/*        Lock lock=new ReentrantLock(true);//new 一个公平锁
        Condition condition=lock.newCondition();//Condition可以精准的通知和唤醒线程
        condition.await();//相当与wait（）
        condition.signalAll();//相当于notifyAll（）*/

        /*
        * synchronized虽然是自动释放锁，但是如果当前获取锁的线程一直阻塞，会造成cpu资源耗尽，
        * ReentrantLock可重入/可中断/可公平
        * 而lock锁有lock.tryLock(1000,TimeUnit.MILLISECONDS);如果获取不到
        * */
        System.out.println("主线程执行开始");
        threadPoolExecutor.execute(()->{
            System.out.println("子线程在执行任务！");
            throw new RuntimeException("子线程抛出了异常！");

        });
        System.out.println("主线程执行结束");
    }


}
