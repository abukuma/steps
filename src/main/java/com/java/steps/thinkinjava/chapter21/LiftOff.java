package com.java.steps.thinkinjava.chapter21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Stupid Boy
 * @Date: 2018/12/19 11:23
 * @Version 1.0
 * @Description:实现Runnable的任务
 */
public class LiftOff implements Runnable {
    private static int taskCount = 0;   //任务计数
    private final int id = taskCount++;     //任务ID
    protected int countDown = 5;   //倒计时

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String Status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
        //输出格式:#0(10)……
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(Status());
            Thread.yield(); //将CPU转移到其他线程，这种转移是由调度机制决定的，只是建议，能展示出任务调入调出的证据
        }
    }
}

//模拟线程驱动，由main()直接调用
class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}

//要实现线程行为，需要显式地将一个任务附到线程上，比如提交给Thread构造器
class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();  //start()方法迅速返回，先执行下一个输出   -->调用LiftOff.run()方法，由其他线程执行，与main()"同时"执行
        System.out.println("Waiting for LiftOff……");
    }
}

//多线程,由于调度的非确定性,每次执行结果不一定相同
class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        System.out.println("Waiting for LiftOff……");
    }
}
//练习：P689

//使用Executor管理Thread对象，简化并发编程，是启动任务的优选方法.使用单个的Executor来创建和管理系统中的所有任务很常见

class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        exe = Executors.newFixedThreadPool(5);
        exe = Executors.newSingleThreadExecutor();
        /*CachedThreadPool 通常会创建所需数量的线程，在回收旧线程时会停止新线程的创建，首选
         *FixedThreadPool 一次性完成线程分配，限制线程的数量，可以节约时间
         * SingleThreadExecutor 类似数量为1的FixedThreadPool，提交多个任务时，会排队，这种方式不需要在资源上处理同步
         */
        for (int i = 0; i < 5; i++) {
            exe.execute(new LiftOff());
        }
        System.out.println("Waiting for LiftOff……");
        exe.shutdown();
    }
}
