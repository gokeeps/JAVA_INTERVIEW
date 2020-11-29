package proxy;

import reflect.Test;

public class PhoneOperation implements Operation {
    @Override
    public String processInfo(String message) {
        System.out.println("processInfo()方法执行");
        return "phone process " + message;
    }
    @Test (name1 = "1", name2 = "2")
    @Override public void show() {
        System.out.println("show()方法执行");
    }

    @Override public void test() {
        System.out.println("test()方法执行");
    }
}
