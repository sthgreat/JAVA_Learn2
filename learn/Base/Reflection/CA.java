package Base.Reflection;

public class CA {
    private String name;
    Integer id;

    CA(){

    }

    CA(String s, Integer i){
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
}
