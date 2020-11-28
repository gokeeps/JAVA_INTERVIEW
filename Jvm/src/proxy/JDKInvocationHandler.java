package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private Operation process;

    public JDKInvocationHandler(Operation process) {
        this.process = process;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (args == null || args.length == 0) {
//            throw new InvalidParameterException("无效的参数， " + this.getClass().getSimpleName());
//        }
        System.out.println("ProcessInvocationHandler before, method name: " + method.getName());
        String res = (String)method.invoke(process, args);
        System.out.println("ProcessInvocationHandler after");
        res += "---append decimal proxy";
        return res;
    }
}
