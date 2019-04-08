package com.java.steps.thinkinjava.chapter21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Stupid Boy
 * @Date: 2018/12/19 11:23
 * @Version 1.0
 * @Description:ʵ��Runnable������
 */
public class LiftOff implements Runnable {
    private static int taskCount = 0;   //�������
    private final int id = taskCount++;     //����ID
    protected int countDown = 5;   //����ʱ

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String Status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
        //�����ʽ:#0(10)����
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(Status());
            Thread.yield(); //��CPUת�Ƶ������̣߳�����ת�����ɵ��Ȼ��ƾ����ģ�ֻ�ǽ��飬��չʾ��������������֤��
        }
    }
}

//ģ���߳���������main()ֱ�ӵ���
class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}

//Ҫʵ���߳���Ϊ����Ҫ��ʽ�ؽ�һ�����񸽵��߳��ϣ������ύ��Thread������
class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();  //start()����Ѹ�ٷ��أ���ִ����һ�����   -->����LiftOff.run()�������������߳�ִ�У���main()"ͬʱ"ִ��
        System.out.println("Waiting for LiftOff����");
    }
}

//���߳�,���ڵ��ȵķ�ȷ����,ÿ��ִ�н����һ����ͬ
class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        System.out.println("Waiting for LiftOff����");
    }
}
//��ϰ��P689

//ʹ��Executor����Thread���󣬼򻯲�����̣��������������ѡ����.ʹ�õ�����Executor�������͹���ϵͳ�е���������ܳ���

class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        exe = Executors.newFixedThreadPool(5);
        exe = Executors.newSingleThreadExecutor();
        /*CachedThreadPool ͨ���ᴴ�������������̣߳��ڻ��վ��߳�ʱ��ֹͣ���̵߳Ĵ�������ѡ
         *FixedThreadPool һ��������̷߳��䣬�����̵߳����������Խ�Լʱ��
         * SingleThreadExecutor ��������Ϊ1��FixedThreadPool���ύ�������ʱ�����Ŷӣ����ַ�ʽ����Ҫ����Դ�ϴ���ͬ��
         */
        for (int i = 0; i < 5; i++) {
            exe.execute(new LiftOff());
        }
        System.out.println("Waiting for LiftOff����");
        exe.shutdown();
    }
}
