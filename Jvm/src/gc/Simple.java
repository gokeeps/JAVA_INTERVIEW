package gc;

public class Simple {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
        new Simple().show();
//        System.gc();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //        System.out.println(list);
    }

    public void show() {
        String a = "哈哈";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("被GC");
        super.finalize();
    }
}
