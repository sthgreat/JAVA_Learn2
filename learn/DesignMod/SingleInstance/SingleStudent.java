package DesignMod.SingleInstance;

public class SingleStudent {
    private volatile static SingleStudent singleStudent;
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        SingleStudent.name = name;
    }

    public static SingleStudent getInstance(){
        if(singleStudent == null){
            synchronized (SingleStudent.class){
                if(singleStudent == null){
                    singleStudent = new SingleStudent();
                }
            }
        }
        return singleStudent;
    }

    public void say(){
        System.out.print("我是学生：" + name);
    }

    public static void main(String[] args){
        SingleStudent s = SingleStudent.getInstance();
        s.setName("里夏鸣");
        s.say();
    }
}
