package DesignMod.Decorator;

public class AnimalDecoratorDog implements component {

    private component animal;

    public AnimalDecoratorDog(component a){
        this.animal = a;
    }

    @Override
    public void function() {
        animal.function();
        this.fuction1();
    }

    public void fuction1(){
        System.out.println("犬吠。");
    }
}
