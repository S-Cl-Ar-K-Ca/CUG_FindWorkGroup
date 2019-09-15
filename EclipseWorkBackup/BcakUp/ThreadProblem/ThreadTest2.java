package ThreadProblem;

public class ThreadTest2 {

    public static void main(String[] args) {
        /*
         * //创建三个实例来卖票 TicketSaleWin ticketSaleWin1 =new TicketSaleWin();
         * TicketSaleWin ticketSaleWin2 =new TicketSaleWin(); TicketSaleWin
         * ticketSaleWin3 =new TicketSaleWin(); Thread thread1 = new
         * Thread(ticketSaleWin1); Thread thread2 = new Thread(ticketSaleWin2);
         * Thread thread3 = new Thread(ticketSaleWin3); thread1.start();
         * thread2.start(); thread3.start();
         */
        // 创建一个示例，被三个线程调用
        TicketSaleWin ticketSaleWin1 = new TicketSaleWin();
        Thread thread1 = new Thread(ticketSaleWin1);
        Thread thread2 = new Thread(ticketSaleWin1);
        Thread thread3 = new Thread(ticketSaleWin1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// 定义一个售票窗口 具有票的总数属性
class TicketSaleWin implements Runnable {

    private volatile int nums = 100; // 这里改成static变量试试 ，被三个实例线程并发修改
                                     // //volatile修饰符只能够保证可见性，一定的有序性，并不能保持原子性
    // 创建一个对象 放进三个线程 对关键字段加同步就行

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // 每半秒出一次票
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (nums > 0) {
                    // Thread.currentThread().getName() 获得当前线程的实例名称
                    System.out.println(Thread.currentThread().getName() + "售票窗口在卖第" + nums + "张票！");
                    nums--;
                } else {
                    System.out.println("++++++++" + Thread.currentThread().getName() + "票已售罄++++++");
                    break;
                }
            }
        }
    }
}