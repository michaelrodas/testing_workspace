package testing;

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

	}
}
