package ThreadProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));  
        for (int i = 1; i <=20; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            Thread.sleep(10);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
                    + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
                + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        executor.shutdown();
    }
}

class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @SuppressWarnings("static-access")
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
