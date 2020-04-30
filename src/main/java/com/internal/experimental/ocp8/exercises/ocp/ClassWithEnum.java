package com.internal.experimental.ocp8.exercises.ocp;

public class ClassWithEnum {
    private enum MyEnum {
        elem, ELEM1, ELEM2
    }

    public static void main(String[] args){
        System.out.println(MyEnum.elem == MyEnum.valueOf("elem"));
    }
}

