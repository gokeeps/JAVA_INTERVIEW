package proxy;

import reflect.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKInvocationHandler implements InvocationHandler {

    private Operation process;
    private int count;

    public JDKInvocationHandler(Operation process, int count) {
        this.process = process;
        this.count = count;
    }

    // 这里写上获取动态代理类
    public Operation createProxy() {
        return (Operation)Proxy
            .newProxyInstance(process.getClass().getClassLoader(), process.getClass().getInterfaces(), this::invoke);
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        count++;
        System.out.println("\n\n");
        System.out.println("Number" + count + "-------JDK动态代理方法开始, 方法名: " + method.getName() + "-----------");
        Test testAnnotation = getMethodAnnotation(Test.class, method.getName(), null);
        if (testAnnotation != null) {
            System.out.println(
                "方法" + method.getName() + "存在Test注解, 参数: name1" + testAnnotation.name1() + ", name2: " + testAnnotation
                    .name2());
            // 这里是$Proxy0.class实现类中调用的invoke方法，相当有在下面的方法之前和之后进行处理
            String res = (String)method.invoke(process, args);
            //System.out.println("重写handler invoke");
            System.out.println("-------JDK动态代理方法结束, 方法名: " + method.getName() + "--------");
            res += "---append decimal proxy";
            return res;
            //return "";
        } else {
            System.out.println();
            System.out.println("方法： " + method.getName() + "未添加注解");
            System.out.println("-------JDK动态代理方法结束, 方法名: " + method.getName() + "--------");
            return method.invoke(process, args);
        }

    }

    /**
     * 找到方法并且获取对象
     *
     * @param annotationClass
     * @param methodName
     * @param args
     * @param <T>
     * @return
     */
    private <T extends Annotation> T getMethodAnnotation(Class<T> annotationClass, String methodName, Class<?>... args) {
        Class classes = process.getClass();
        Method[] methods = classes.getMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                if (args == null || args.length == 0) {
                    return method.getAnnotation(annotationClass);
                }
                Class<?>[] methodParams = method.getParameterTypes();
                for (int i = 0; i < methodParams.length; i++) {
                    if (i <= args.length - 1 && Arrays
                        .equals(methodParams[i].getTypeParameters(), args[i].getTypeParameters())) {
                        return method.getAnnotation(annotationClass);
                    }
                }
            }
        }
        return null;
    }
}
