package DesignMod.Proxy.DongTai;

public class MyBeforeAdvice implements BeforeAdvice {
    @Override
    public void before() {
        System.out.println("之前");
    }
}
