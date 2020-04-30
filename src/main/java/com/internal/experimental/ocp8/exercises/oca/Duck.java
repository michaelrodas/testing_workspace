package com.internal.experimental.ocp8.exercises.oca;

public class Duck extends Bird implements  Waterfoul{
 int entero = 10;
    public static void main(String... args){
        int entero = 5;
        double algo = 9000;
        int num = '5';
        System.out.println(algo);
        String a = "hello";
        String b = new String(a);
        System.out.println("hello"==a);
        System.out.println("hello"==b);
        Object obj = new Bird();
        //Duck duck = (Duck) obj;
        //duck.quack();
        /*
        try {
            main(args);
        } catch (Exception ex) {
            System.out.println("CATCH-");
        }
        System.out.println("OUT");*/
    }

    public void quack(){
        System.out.println("quack!");
    }
}

interface Waterfoul{}
class Bird{}