package com.internal.experimental.ocp8.exercises.oca;

interface A{
    default String getAddress(){
        return "in A";
    }
}

interface B{
    default String getAddress(){
        return "in B";
    }
}

public class Interfaces implements A,B {

    @Override
    public String getAddress() {
        return null;
    }
}
