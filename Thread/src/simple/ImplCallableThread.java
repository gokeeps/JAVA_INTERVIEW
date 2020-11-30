package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ImplCallableThread implements Callable<Integer> {

    private Integer num;

    public ImplCallableThread(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        return num + 1;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Callable<Integer> callable = new ImplCallableThread(i);
            Future<Integer> future = executorService.submit(callable);
            futures.add(future);
        }
        executorService.execute(new Runnable() {
            @Override public void run() {
                System.out.println("Hello");
            }
        });
        executorService.shutdown();


        futures.forEach(future -> {
            try {
                System.out.println("返回结果" + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
