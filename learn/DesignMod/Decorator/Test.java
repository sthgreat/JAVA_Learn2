package DesignMod.Decorator;

public class Test {
    public static void main(String[] args){
        component c = new AnimalDecoratorDog(new Animal());
        c.function();
        component d = new AnimalDecoratorDog(c);
        d.function();
    }
}
