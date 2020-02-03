package DesignMod.Proxy.DongTai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubmit implements InvocationHandler {
    private SubmitHomework classSubmit;

    public ProxySubmit(SubmitHomework classSubmit){
        this.classSubmit = classSubmit;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始...");
        Object result = method.invoke(classSubmit,args);
        System.out.println("结束...");
        return result;
    }
}
