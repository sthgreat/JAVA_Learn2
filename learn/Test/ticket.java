package Test;

public class ticket{
    private int store = 100;

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public synchronized void buy() {
            if(store>=1){
                store -= 1;
                System.out.print(Thread.currentThread().getName() + "拿到了票！还剩" + store + "张" + "\n");
            }
    }
}
