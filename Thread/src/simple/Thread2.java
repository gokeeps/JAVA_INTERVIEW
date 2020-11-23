package simple;

public class Thread2 implements Runnable{
    private String arg;

    public Thread2(String arg) {
        this.arg = arg;
    }

    @Override
    public void run() {
        System.out.println(this.arg);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Thread2("1"));
//        t1.setPriority(10);
        t1.start();

        Thread t2 = new Thread(new Thread2("2"));
//        t2.setPriority(5);
        t2.start();

        Thread t3 = new Thread(new Thread2("3"));
//        t3.setPriority(1);
        t3.start();

    }
}
