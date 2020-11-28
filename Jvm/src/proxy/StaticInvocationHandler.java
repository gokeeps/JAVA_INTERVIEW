package proxy;

import java.security.InvalidParameterException;

public class StaticInvocationHandler implements Operation {
    private Operation operation;

    public StaticInvocationHandler(Operation operation) {
        this.operation = operation;
    }

    @Override public String processInfo(String message) {
        System.out.println("OperationInvocationHandler before");
        if (message == null) {
            throw new InvalidParameterException("无效的参数");
        }
        String res = operation.processInfo(message);
        res = res + "(invocation append data string)";
        System.out.println("OperationInvocationHandler after");
        return res;
    }

    @Override public void show() {
        System.out.println("呵呵");
    }

    @Override public void test() {

    }
}
