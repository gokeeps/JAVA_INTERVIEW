package proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibInvocationHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
        System.out.println("cglib动态代理开始");
        Object obj =  methodProxy.invokeSuper(o, objects);
        System.out.println("cglib动态代理结束");
        return obj;
    }
}
