package DesignMod.Proxy.DongTai;

public class MyAfterAdvice implements AfterAdvice {
    @Override
    public void after() {
        System.out.println("之后...");
    }
}
