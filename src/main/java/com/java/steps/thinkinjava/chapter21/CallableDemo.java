package com.java.steps.thinkinjava.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author: Stupid Boy
 * @Date: 2018/12/19 12:57
 * @Version 1.0
 * @Description:ʵ��Callable������,������ֵ
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        /*submit()���������Future������Callable���ؽ�����ض����ͽ����˲�������������isDone()����ѯFuture�Ƿ���ɣ���ɺ�ʹ��
         *get()������ȡ������ڲ�ʹ��isDone()����ֱ��ʹ��get()������ѯ���ʱ��������get()��ֱ�����׼�����
         */

        for (Future<String> result : results
        ) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult:" + id;
    }
}
