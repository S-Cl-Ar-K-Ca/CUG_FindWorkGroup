package ThreadProblem;

/*
 * 如何通过继承Thread类来创建和使用一个线程：（同时用接口runnable来创建进程）
 * 
 * 让控制台每间隔一秒自动输出一个hello world
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        exThread t1 = new exThread();
        t1.start();
        // t1.start(); //java.lang.IllegalThreadStateException:一个实例的进程只能启动一次
        /*
         * exThread t3 = new exThread(); t3.start();
         */ // 多实例多线程是合法的
        imThread imThread = new imThread();
        Thread t2 = new Thread(imThread);
        t2.start();
        // t2.start(); //java.lang.IllegalThreadStateException:一个实例的进程只能启动一次
    }
}

// 继承实现进程
class exThread extends Thread {

    @Override
    public void run() {
        int couter = 0;
        while (couter < 100) {
            System.out.println("继承实现的线程在运行 " + (couter + 1) + "次");
            couter++;
            try {
                Thread.sleep(500); // 休眠300 毫秒 进入阻塞状态 wait()方法使进程挂起
                                   // 等待其他线程notify()操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置条件 使进程死亡
            if (couter == 50)
                break;
        }
    }
}

// 接口实现线程
class imThread implements Runnable {

    @Override
    public void run() {
        int life = 100;
        while (life > 0) {
            System.out.println("接口实现的进程剩余执行" + (life - 1) + " 次数");
            life--;
            try {
                Thread.sleep(400);// 休眠400 毫秒 进入阻塞状态 wait()方法使进程挂起
                                  // 等待其他线程notify()操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程的死亡条件
            if (life == 90) {
                break;
            }
        }
    }
}
