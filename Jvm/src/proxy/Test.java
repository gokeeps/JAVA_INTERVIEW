package proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 保留代理生成的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 设置cglib代理类生成文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\workspace\\idea\\JAVA_INTERVIEW\\tmp");
        testStaticProxy();
        System.out.println("----------------------");
        testJDKProxy();
        System.out.println("----------------------");
        testCgLibProxy();
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
        JDKInvocationHandler invocationHandler = new JDKInvocationHandler(operation, 0);
        // 获取会产生一个新的实现实例（需要描述被代理对象的，类加载器，接口方法，代理对象）
        // invocationOperation只能是一个接口引用，而不是一个具体的实现
//        Operation invocationOperation = (Operation)Proxy.newProxyInstance(operation.getClass().getClassLoader(),
//            Operation.class.getInterfaces(), invocationHandler);
        Operation invocationOperation = invocationHandler.createProxy();
        String processedRes = invocationOperation.processInfo("Hello");
        invocationOperation.show();
    }

    public static void testCgLibProxy() {
        CgLibInvocationHandler invocationHandler = new CgLibInvocationHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(invocationHandler);
        enhancer.setSuperclass(PhoneOperation.class);
        PhoneOperation phoneOperation = (PhoneOperation)enhancer.create();
        phoneOperation.show();

    }
}
