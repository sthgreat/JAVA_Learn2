package DesignMod.Proxy.DongTai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setAfterAdvice(new MyAfterAdvice());
//        proxyFactory.setBeforeAdvice(new MyBeforeAdvice());
//        proxyFactory.setTargetObject(new MyTestObject());
//        TestObject proxyInstance = (TestObject) proxyFactory.creatProxy();
//        proxyInstance.say();
        MyTestObject myTestObject = new MyTestObject();
        TestObject o = (TestObject) Proxy.newProxyInstance(myTestObject.getClass().getClassLoader(),
                myTestObject.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("在这之前做些什么");
                        Object result = method.invoke(myTestObject, args);
                        System.out.println("在这之后做些什么");
                        return result;
                    }
                });
        o.say();
    }
}
