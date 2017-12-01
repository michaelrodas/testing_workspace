package testing;

import static java.util.Arrays.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class Whizlabs {

	public static void main(String[] args) {
		ArrayList<String> whizlArray = new ArrayList<String>();
		whizlArray.add("coke");
		whizlArray.add("pepsi");
		whizlArray.add("miranda");
		
		System.out.println("Total Array List::" + whizlArray);
		String[] ws1 = new String[whizlArray.size()];
		String[] ws2 = whizlArray.toArray(ws1);
		System.out.println("ws1 == ws2" + (ws1==ws2));
		System.out.println("ws1" + Arrays.toString(ws1));
		System.out.println("ws2" + Arrays.toString(ws2));
		
		ws1 = new String[1];
		ws1[0] = "Test Data";
		ws2 = whizlArray.toArray(ws1);
		
		System.out.println("ws1 == ws2" + (ws1==ws2));
		System.out.println("ws1" + Arrays.toString(ws1));
		System.out.println("ws2" + Arrays.toString(ws2));
		sort(ws2);
		asList(ws2);
		
		int x = 3;
		int y = ++x * 4 / x-- + --x;
		// y = 4 * 4 / x-- + --x
		// y = 4 * 4 / 4 + --x   x decrements after operation
		// y = 4 * 4 / 4 + 2  x is 2
		// y = 16 / 4 +2
		//y = 4 +2
		// y = 6
		System.out.println("x + y=" + (x+y)); // 2 + 6
		
		Integer array[] = new Integer[0];
		//System.out.println(array[0]);
		
		Object numObj = new Integer(2);
		//String str = (String)numObj;
		//System.out.println(str);
		Instant start = Instant.now();
		LocalDate date = LocalDate.parse("2014-12-30");
		Period p = Period.ofDays(2);
		date = date.plusDays(2);
		System.out.println(date.plus(p));
		Instant end = Instant.now();
		Duration dur = Duration.between(start, end);
		System.out.println(dur.toMillis());
		
	}
}
