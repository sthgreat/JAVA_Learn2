package MyIOC;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class myIOC {
    private Map<String, Object> beanMap = new HashMap<>();

    public void test() throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("MyIOC.MyConfigure");
        Method[] declaredMethods = c.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method.getName());
        }
    }
}
