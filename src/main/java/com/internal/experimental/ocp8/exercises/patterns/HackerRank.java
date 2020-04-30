package com.internal.experimental.ocp8.exercises.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Michaelr on 17/04/2018.
 */
public class HackerRank {
    public static void main(String... args){
        String s = "abcdac";
        StringBuilder newString = new StringBuilder(s);
        char[] chars= s.toCharArray();
        long n=10000;
        Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());
        /*
        Map<Integer, Integer> result = nums.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), Integer.valueOf(Collectors.counting().toString())));
                        */
        //result.forEach((k,v) -> System.out.println("k:"+k+" v:"+v));
        //filter(i -> Collections.frequency(nums, i) > 1)
        /*
        List<Character> myList = new ArrayList(s.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        myList = IntStream.range(0, (int)n).map(index -> {
            if (index == chars.length)
                index = 0;
            else
                index++;
            return chars[index];
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //char[] chars = s.toCharArray();

        */
    }

}
