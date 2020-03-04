package DesignMod.Proxy.DongTai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setAfterAdvice(new MyAfterAdvice());
        proxyFactory.setBeforeAdvice(new MyBeforeAdvice());
        proxyFactory.setTargetObject(new MyTestObject());
        TestObject proxyInstance = (TestObject) proxyFactory.creatProxy();
        proxyInstance.say();
    }
}
