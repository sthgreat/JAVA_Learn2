package DesignMod.Decorator;

public class Animal implements component{
    @Override
    public void function() {
        System.out.println("进食，休息。");
    }
}
