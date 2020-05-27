package Concurrent_Programe.consumerAndProductor.practice1;

public class Product1 {
    private String name;
    private int price;

    public Product1(){
    }

    public Product1(String n, int p){
        this.name = n;
        this.price = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
