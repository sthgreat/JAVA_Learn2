package DesignMod.SingleInstance;

public class Student {
    private int old;
    private String name;

    public Student(int a, String b){
        this.old = a;
        this.name = b;
    }

    public void say(){
        System.out.print("我是学生：" + name);
    }
}
