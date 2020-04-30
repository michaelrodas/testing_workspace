package com.internal.experimental.ocp8.exercises.oca;

import java.io.IOException;

class Amphibian {
    private void print() {
        System.out.println("in Amphibian");
    }

    public void callPrint() {
        /*
         * This will DIRECTLY call Amphibian.print(), regardless of whether the
         * current object is an instance of Amphibian or Frog, and whether the
         * latter hides the method or not.
         */
        print(); // this call is bound early
    }
}

class Frog extends Amphibian {
    public void print() {
        System.out.println("in Frog");
    }

    public static void main(String[] args) {
        Frog f = new Frog();
        f.callPrint(); // => in Amphibian

        // this call is bound late
        f.print(); // => in Frog
    }
}

class Connector{
    Connector() throws IOException{}
}

class CleanConnector extends Connector{

    CleanConnector() throws IOException {
    }
}

