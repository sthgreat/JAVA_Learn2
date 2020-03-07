package DesignMod.Proxy.DongTai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class ProxyFactory {
    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;//前值增强
    private AfterAdvice afterAdvice;//后置增强

    /**
     * 用来生成代理对象
     * @return
     */
    public Object creatProxy() {
        /**
         * 给出三个参数
         */
        ClassLoader classLoader = targetObject.getClass().getClassLoader();
        //获取当前类型所实现的所有接口类型
        Class[] interfaces = targetObject.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 在调用代理对象的方法时，会执行这里的内容
                 */
                if(beforeAdvice != null) {
                    beforeAdvice.before();
                }
                Object result = method.invoke(targetObject, args);//调用目标对象的目标方法
                //执行后续增强
                afterAdvice.after();

                //返回目标对象的返回值
                return result;
            }
        };
        /**
         * 2、得到代理对象
         */
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

    }
//get和set方法略

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
