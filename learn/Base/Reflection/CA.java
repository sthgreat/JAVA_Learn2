package Base.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CA {
    private String name;
    Integer id;

    @Override
    public String toString() {
        return "CA{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    CA(){
    }

    private CA(String s, Integer i){
        this.name = s;
        this.id = i;
    }

    CA(String s){
        this.name = s;
    }

    public void say(){
        System.out.println("说话");
    }

    private void eat(){
        System.out.println("吃饭");
    }

    //反射一个对象
    public CA reflactNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("Base.Reflection.CA");
        CA o = (CA) c.newInstance();
        o.setName("jsn");
        o.setId(1);
        System.out.println(c.toString());
        return o;
    }

    //反射私有构造方法
    public void reflactConstuctor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("Base.Reflection.CA");
        Constructor<?> constructor = c.getDeclaredConstructor(String.class, Integer.class);
        constructor.setAccessible(true);
        CA o = (CA) constructor.newInstance("jkl",9);
        System.out.println(o.toString());
    }

    //反射私有属性
    public void reflactField() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("Base.Reflection.CA");
        Object o = c.newInstance();
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        String o1 = (String) name.get(o);
        System.out.println(o1);
    }

    //反射私有方法
    public void reflectPrivateMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> c = Class.forName("Base.Reflection.CA");
        Object o = c.newInstance();
        Method eat = c.getDeclaredMethod("eat");
        eat.setAccessible(true);
        eat.invoke(o);
    }
}
