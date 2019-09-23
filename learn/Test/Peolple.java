package Test;

class People implements Runnable{
    private ticket t;

    public People(ticket t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true){
            if(t.get()<=0){
                break;
            }
            t.set();
            System.out.print(Thread.currentThread().getName()+"还剩"+t.get()+"\n");
        }
    }
}
