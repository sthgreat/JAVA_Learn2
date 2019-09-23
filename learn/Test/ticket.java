package Test;

public class ticket{
    ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public Integer get(){
        return t.get();
    }

    public void set(){
        t.set(t.get() - 1);
    }
}
