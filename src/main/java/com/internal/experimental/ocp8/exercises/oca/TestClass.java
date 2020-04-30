package com.internal.experimental.ocp8.exercises.oca;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    int age;//1
}

interface House{
    public default String getAddress(){
        return "101 Main Str";
    } }

    interface Bungalow extends House{
    public default String getAddress(){
        return "101 Smart Str";
    } }


public class TestClass implements Bungalow, House{
    static String str;

    public static boolean validateEmployee(Employee e, Predicate<Employee> p) {
        return p.test(e);}

    public static void main(String[] args) {
        Employee e = new Employee(); //2       
        System.out.println(validateEmployee(e, x -> x.age < 10000)); //3   
        System.out.println(str);

        House myt = new TestClass();
        System.out.println(myt.getAddress());
        System.out.println( 23 / 2.0 );
        byte ss = 10;
        short s = 10;
        int sss = 10;
        char c = (char) s;
        char cc = (char) ss;
        char ccc = (char) sss;
        ss = (byte) s;
        ss = (byte) sss;
        s = ss;
        s = (short) sss;
        sss = c;

        int rate = 10;
        float amount = 1 - rate/100*1 - rate/100;
        System.out.println(amount);

        System.out.println(1 + 5 < 3 + 7);
        System.out.println( (2 + 2) >= 2 + 3);

        int i=0, j=10;
        while (i<=j) {
            i++;
            j--;
        }
        System.out.println(i+" "+j);

        System.out.println("" +5 + 6);
        System.out.println(5 + "" +6);
        System.out.println(5 + 6 +"");
        System.out.println(5 + 6);

        List s1 = new ArrayList( ); s1.add("a"); s1.add("b"); s1.add("c"); s1.add("a");
        System.out.println(s1.remove("a")+" "+s1.remove("x"));

       System.out.println(parseFloat("0.0"));

        switch(5)
        {
            default :
        }

        int number=2;
        StringBuilder aString = new StringBuilder("empty");
        List<String> myList = new ArrayList<>();
        System.out.println("List size before: "+ myList.size() + " and number: " + number + " s size: " + aString.length());
        modifyList(myList, number, aString);
        System.out.println("List size after: "+ myList.size()+ " and number: " + number+ " s size: " + aString.length());

        for (int l = 0; l < args.length; l++)   System.out.print(l == 0 ? args[l] : " " + args[l]);

        double num=10;
        prove(num);

        int[] arr = {1, 2};
        int[][] arr2 = {arr, {1, 2}, arr};
        int[][][] arr3 = {arr2};
        System.out.println(arr3.length);

        int x = 10;
        String y = "Z";
        System.out.println(x+y);

        boolean b1 = false;
        int i1 = 2;
        int i2 = 3; if (b1 = i1 == i2){
            System.out.println("true"); } else{
            System.out.println("false"); }

        Period period = Period.parse("P0Y1000M0D");
        System.out.println(period);

        add(10.0, new Integer(10));

        char letter = 'c';
        do System.out.print(letter++);
        while (letter <='f');

        LocalDate dia = LocalDate.now();
        //System.out.println(dia.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println();
        int[][] matrix = new int[2][4];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6};
        for (int[] u: matrix) {
            for (int v: u) {
                System.out.print(v);
            }
        }

        List mysecond = new ArrayList<String>();
    }

    static void prove(Number num){
        System.out.println("in Number");
    }

    static void prove(Object num){
        System.out.println("in Object");
    }

    private static void modifyList(List<String> myList, int number, StringBuilder s) {
        myList.add("1");
        myList.add("2");
        number = 666;
        s.append("something");
    }

    public static float parseFloat( String s){
        float f = 0.0f;
        try{
            f = Float.valueOf( s ).floatValue();
            return f;
        }catch(NumberFormatException nfe){
            f = Float.NaN ;
            return f;
        }  finally{
            f = 10.0f;
            return f;
        } }

    private static void add(double d1, double d2) {
        System.out.println("double version: " + (d1 + d2));
    }

    private static void add(Double d1, Double d2) {
        System.out.println("Double version: " + (d1 + d2));
    }

}