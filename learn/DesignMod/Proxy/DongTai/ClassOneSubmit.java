package DesignMod.Proxy.DongTai;

public class ClassOneSubmit implements SubmitHomework {
    @Override
    public void submit() {
        System.out.println("班级一提交了作业");
    }

    public void ok(){
        System.out.println("批改完成！");
    }
}
