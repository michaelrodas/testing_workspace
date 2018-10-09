package exercises.patterns;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by MichaelR on 16/03/2018.
 */
public class Numbers {


    public static void main(String[] args) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
       LocalDate d = LocalDate.of(2017, Month.SEPTEMBER,13);
       // LocalDate d = LocalDate.now();
        System.out.println(d.format(formatter)+ Year.isLeap(1918));

        double number = 125.3;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(currencyFormatter.format(number));

        int[] ar = {10,20,20,10,10,30,50,10,20};
        System.out.println(sockMerchant(ar));
    }

    static int sockMerchant(int[] ar) {
        Map<Integer, Long> counting = Arrays.stream(ar).boxed().collect(
                Collectors.groupingBy(s -> s, Collectors.counting()));

        int pairCounter = counting.entrySet().stream().mapToInt(
          (e) -> e.getValue()%2==0?(int)(e.getValue()/2):(int)((e.getValue()-1)/2)).sum();
        return pairCounter;
    }
}
