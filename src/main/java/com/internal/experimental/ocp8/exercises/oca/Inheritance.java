package com.internal.experimental.ocp8.exercises.oca;

import java.io.FileNotFoundException;
import java.io.IOException;

abstract class Super {
    public abstract void m1() throws IOException;
}

class Sub extends Super {
    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Super s = new Sub();
        /*
        try {
            s.m1();
        } catch (FileNotFoundException e) {
            System.out.print("M");
        } finally {
            System.out.print("N");
        }*/
    }

    class Hopper {
        public void hop() throws Exception { }
    }
    class Bunny extends Hopper {
        public void hop() throws  Exception{ }
    }
}