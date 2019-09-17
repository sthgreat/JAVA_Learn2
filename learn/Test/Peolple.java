package Test;

class People implements Runnable{
    private volatile ticket ticket;

    public People(Test.ticket ticket) {
        this.ticket = ticket;
    }


    @Override
    public void run() {
//        for(int i =50;i>=0;i--){
        while (true){
            if(ticket.getStore()<=0){
                break;
            }
            this.ticket.buy();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        }
    }
}
