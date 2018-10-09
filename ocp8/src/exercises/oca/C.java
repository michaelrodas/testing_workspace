package exercises.oca;

import exercises.jdbc.A;

import java.io.FileNotFoundException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class C extends A {
    //    A a = new C();
    public static void main(String[] args) {
        A a = new C();
        try {
            ((C) a).sobrescritura();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // C c = new A();
        ((A) a).overw();
        byte num = 100;
        switch (num) {
            case 100:
                System.out.println("algo");
        }
        int[] array = {2, 3, 4};
        ArrayList<Integer> list = new ArrayList<>();
        list.clone();
        char var = 7;
        Character var2 = 7;
        switch (var) {
        }
        switch (var2) {
        }
        System.out.print(new StringBuilder("Java"));

        do {
            System.out.println(100);
        } while (false);
        System.out.println("Bye");

        Period period = Period.of(0, 0, 0);
        System.out.println(period);
        //System.out.println("Output is: " + 10 != 5);
        //LocalDate date = LocalDate.of(2020, 9, 31);
        // System.out.println(date);

        LocalDateTime obj = LocalDateTime.now();
        System.out.println(obj.getSecond());

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2018-07-11"));
        dates.add(LocalDate.parse("1919-02-25"));
        dates.add(LocalDate.of(2020, 4, 8));
        dates.add(LocalDate.of(1980, Month.DECEMBER, 31));

        dates.removeIf(x -> x.getYear() < 2000);

        System.out.println(dates);

        LocalDate date = LocalDate.parse("1947-08-14");
        LocalTime time = LocalTime.MAX;
        System.out.println(date.atTime(time));
        System.out.println(time);
        date.minus(Period.ofDays(10));
        int cien = 100;
        System.out.println(-cien++);

        Integer[] anums = new Integer[1];
        System.out.println(anums[0]);

        String str = "java";
        StringBuilder sb = new StringBuilder("java");
        System.out.println(str.equals(sb) + ":" + sb.equals(str));

        byte var6 = 100;
        Integer num6 = 100;
        Integer num7 = 101;
        num6.equals(num7);
        List<String> list2 = new ArrayList();

        switch (var6) {
            case 100:
                System.out.println("var is 100");
                break;
            /*case 200:
                System.out.println("var is 200");
                break;*/
            default:
                System.out.println("In default");
        }

        String fruit = "mango";
        String banana = "Banana";
        switch (fruit) {
            case "Apple":
                System.out.println("APPLE");
            case "Mango":
                System.out.println("MANGO");
            case "Banana":
                System.out.println("BANANA");
                break;
            default:
                System.out.println("ANY FRUIT WILL DO");
        }

        String fruit2 = "mango";
        switch (fruit2) {
            default:
                System.out.println("ANY FRUIT WILL DO2");
            case "Apple":
                System.out.println("APPLE2");
            case "Mango":
                System.out.println("MANGO2");
                // case "mango":     System.out.println("right one");break;
            case "Banana":
                System.out.println("BANANA2");
                break;
        }

        long l = 100_00l;
        int i = 100;
        float f = 2.02f;
        double d = 10_0.35d;
        f = l;
        d = l;
        //f = d;
        d = f;
        f = i;
        //i = f;
        i = (int) d;

        //System.out.println(LocalDate.parse("2018-7-11"));
        walk(1, null);

        boolean flag = false;
        while (flag) {
            System.out.println("Good Morning!");
        }

        boolean keepGoing = true;
        int count = 0;
        int x = 3;
        while (count++ < 3) {
            int y = (1 + 2 * count) % 3;
            switch (y) {
                default:
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 5;
            }
        }
        System.out.println(x);
    }

    final public void walk7() {
    }

    public void overw(){
        System.out.println("In C");
    }

    public static void walk(int start, int... nums) {
        //System.out.println(nums.length);
    }

    public void sobrescritura() throws FileNotFoundException {
    }
}


interface Ani {
    public default String getName() {
        return null;
    }
}

interface Mammal {
    public default String getName() {
        return null;
    }
}

abstract class Otter implements Mammal, Ani {
    @Override
    public String getName() {
        return null;
    }
}

interface Anim {
    public default String getName() {
        return null;
    }
}

interface Mamma {
    public String getName();
}
//abstract class Otter3 implements Mamma, Anim{


interface An {
    public String getName();
}

interface Mamm {
    public String getName();
}

abstract class Otter2 implements Mamm, An {
}

interface HasTail{
    int getTailLength();
}

abstract class Puma implements HasTail {

    public int getTailLength() {
        return 4;
    }
}

class Cougar extends Puma {
    public static void main(String[] args) {
        System.out.println();
        Puma puma = new Cougar();
        System.out.println(puma.getTailLength());
    }

    int getTailLength(int length) {
        return 2;
    }
}

