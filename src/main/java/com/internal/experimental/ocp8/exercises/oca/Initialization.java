package com.internal.experimental.ocp8.exercises.oca;

public class Initialization {
    static int var1 = 1;
    int var2 = 2;
    int var3 = getVar3();
    int var4;

    private int getVar3() {
        return 3;
    }

    Initialization(){
        this.var4 = 4;
    }

    @Override
    public String toString(){
        return "var1: "+ var1 + " var2: " + var2 + " var3: " + var3 + " var4: " + var4;
    }

    public static void main(String... args){
        Initialization init = new Initialization();
        System.out.println(init.toString());
    }
}
