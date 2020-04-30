package com.internal.experimental.ocp8.exercises.oca;

public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        myAnimal.testClassMethod();
        testClassMethod();

        int i=0;
        try{
            i = Integer.parseInt("parse");
        }catch (NumberFormatException e){
            System.out.println("problem in: " + i);
        }
    }
}