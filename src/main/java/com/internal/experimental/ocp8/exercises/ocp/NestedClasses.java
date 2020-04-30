package com.internal.experimental.ocp8.exercises.ocp;

public class NestedClasses {
    public static void main(String[] args)  {
        Program p = new Program();
        p.method();
        Program2 p2= new Program2();
        p2.methodInStatic();
        new Outer().new Inner().method();

    }
}

class Outer {
    class Inner {
        void method() {
            System.out.println("method called");
        }
    }

    static class Nested{
        void methodInStatic(){
            System.out.println("static called");
        }
    }

}

class Program  extends Outer.Inner {
    Program() {
        new Outer().super();
    }
}

class Program2 extends Outer.Nested{

}

