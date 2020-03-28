package Base.Reflection;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("Base.Reflection.CA");
        Object o = c.newInstance();
    }
}
