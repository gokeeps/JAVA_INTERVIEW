package proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 保留代理生成的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        testStaticProxy();
        System.out.println("----------------------");
        testJDKProxy();
    }


    public static void testStaticProxy() {
        System.out.println("静态代理");
        // 被代理对象本身
        Operation phoneOperation = new PhoneOperation();
        // 把它交给一个代理对象，获取到一个新的实现实例
        Operation invocationHandler = new StaticInvocationHandler(phoneOperation);
        String processedRes = invocationHandler.processInfo("Hello");
        System.out.println("process res = " + processedRes);
    }

    public static void testJDKProxy() {
        System.out.println("JDK动态代理");
        // 被代理对象本身
        Operation operation = new PhoneOperation();
        // 交给一个代理对象
        JDKInvocationHandler invocationHandler = new JDKInvocationHandler(operation);
        // 获取会产生一个新的实现实例（需要描述被代理对象的，类加载器，接口方法，代理对象）
        Operation invocationOperation = (Operation)Proxy.newProxyInstance(operation.getClass().getClassLoader(),
            operation.getClass().getInterfaces(), invocationHandler);

        String processedRes = invocationOperation.processInfo("Hello");
        invocationOperation.show();

        invocationOperation.toString();
        System.out.println("process res = " + processedRes);
    }

    public static void testCgLibProxy() {
//        Enhancer




    }
}
