package com.java.steps.thinkinjava.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author: Stupid Boy
 * @Date: 2018/12/19 12:57
 * @Version 1.0
 * @Description:实现Callable的任务,带返回值
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        /*submit()方法会产生Future对象，用Callable返回结果的特定类型进行了参数化，可以用isDone()来查询Future是否完成，完成后使用
         *get()方法获取结果，在不使用isDone()方法直接使用get()方法查询结果时，会阻塞get()，直至结果准备完成
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
