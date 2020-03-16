package DesignMod.SingleInstance;

public class StaticSingleStudent {
    private StaticSingleStudent(){
    }

    public static StaticSingleStudent getInstance(){
        return Instance.student;
    }

    private static class Instance{
        private static final StaticSingleStudent student = new StaticSingleStudent();
    }
}
