package testing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class ExampleTest {

	static{
		
	}
	private static String HOLA="HOLA";
	
	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = new String("Java");
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Ja").append("va");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1.toString() == s1);
		System.out.println(sb1.toString().equals(s1));
		
		HOLA = "hola2";
		
		int algo = 0_2_6;
		String _="";
		System.out.println(algo+1);
		
		int dayOfWeek = 5;
		switch (dayOfWeek) {
		case 0:
			System.out.println("Sunday");
		default:
			System.out.println("Weekday");
		case 6:
			System.out.println("Saturday");
			break;
		}

		int var ='7';

		final boolean flag;
		flag = false;
		while(flag) {
			System.out.println("Good Morning!");
		}

		int i;
		for(i=0; i<=2; i++){}
		System.out.println(i);

        Boolean [] arr = new Boolean[2];
        List<Boolean> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);

        if(list.remove(0)) {
            list.remove(1);
        }

        String bbb = new String(new char[]{'h','a'});
		
		try {
			testMethod();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void testMethod() throws IOException{

		throw new FileNotFoundException();
	}
}
