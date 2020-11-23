package simple;

import java.util.HashSet;
import java.util.Set;

/**
 *     sleep(): 强迫一个线程睡眠Ｎ毫秒。
 * 　　isAlive(): 判断一个线程是否存活。
 * 　　join(): 等待线程终止。
 * 　　activeCount(): 程序中活跃的线程数。
 * 　　enumerate(): 枚举程序中的线程。
 *     currentThread(): 得到当前线程。
 * 　　isDaemon(): 一个线程是否为守护线程。
 * 　　setDaemon(): 设置一个线程为守护线程。(用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束)
 * 　　setName(): 为线程设置一个名称。
 * 　　wait(): 强迫一个线程等待。
 * 　　notify(): 通知一个线程继续运行。
 * 　　setPriority(): 设置一个线程的优先级。
 */
public class Thread1 extends Thread {

    private int arg;

    public Thread1(int arg) {
        this.arg = arg;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( this.arg * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.arg);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread1(1);
        t1.start();
//        t1.join();
        Thread t2 = new Thread1(2);
        t2.start();
//        t2.join();
        Thread t3 = new Thread1(3);
        t3.start();
//        t3.join();

        Set<String> a = new HashSet<>();
        a.add("aaa");
        "".contains("ade")
        char b = 1;
        a.add(String.valueOf(b));
    }
}
