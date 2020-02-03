package Test;

public class demo_chushihua {
    public static void main(String[] args){
//        father.print();
        son s = new son();
    }
}

class father{
    public static int A = 1;
    public static String s = "hello";
    public int B = 2;

    static{
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public static void print(){
        System.out.print("父类静态方法");
    }

    public father(){
        System.out.println("父类构造方法");
    }
}

class son extends father{
    public static int a = 100;
    public static String s = "hello father";
    public int b = 200;

    static{
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
        b = super.B + 3;
    }

    public son(){
        System.out.println("子类构造方法");
        System.out.print(b);
    }

    public static void print(){
        System.out.print("子类静态方法（重写）");
    }
}
