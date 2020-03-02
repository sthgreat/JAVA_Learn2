package DesignMod.SingleInstance;

public class Student {
    private int old;
    private String name;
    private volatile static Student student;

    private Student(){

    }

    public static Student getInstance(){
        if(student == null){
            synchronized (Student.class){
                if(student == null){
                    student = new Student();
                }
            }
        }
        return student;
    }



    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
