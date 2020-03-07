package Concurrent_Programe.consumerAndProductor;

public class Product {
    private String name;
    private double price;
    private String desc;
    private Integer count;
    public volatile boolean canProduce;
    public volatile boolean canConsume;

    public Product(String name, double price, String desc, Integer count) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.count = count;
        if(count >= 10){
            canProduce = false;
            canConsume = true;
        }else if(count <= 0){
            canProduce = true;
            canConsume = false;
        }else{
            canProduce = true;
            canConsume = true;
        }
    }

    public void consume(){
        if(this.count >= 1){
            this.count -= 1;
            if(this.count == 0){
                canConsume = false;
                canProduce = true;
            }else{
                canConsume = true;
                canProduce = true;
            }
        }
    }

    public void produce(){
        if(this.count <= 9){
            this.count+=1;
            if(this.count == 10){
                canProduce = false;
                canConsume = true;
            }else{
                canConsume = true;
                canProduce = true;
            }
        }
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
