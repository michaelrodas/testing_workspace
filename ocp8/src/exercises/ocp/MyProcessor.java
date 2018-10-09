package exercises.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

class MyProcessor {
    int value;

    public MyProcessor() {
        value = 10;
    }

    public MyProcessor(int value) {
        this.value = value;
    }

    public void process() {
        System.out.println("Processing " + value);
    }

    public static void main(String... args){
        Function<Integer, MyProcessor> f = MyProcessor::new;
        MyProcessor mp = f.apply(10);
        mp.process();

        Supplier<MyProcessor> supp = MyProcessor::new;
        MyProcessor mp2 = supp.get();
        mp2.process();


        List<String> messages = Arrays.asList("-", "-");
        messages.stream().forEach(s->s.concat("helloworld"));
        messages.forEach(s->{
            s.replace('o',',');
            System.out.println(s); });


    }
}
