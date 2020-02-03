package DesignMod.Proxy.DongTai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        SubmitHomework classOne = new ClassOneSubmit();
        InvocationHandler handler = new ProxySubmit(classOne);
        SubmitHomework c = (SubmitHomework) Proxy.newProxyInstance(classOne.getClass().getClassLoader(), classOne.getClass().getInterfaces(), handler); //代理对象由jdk在内存中动态构建
        c.submit();
    }
}
