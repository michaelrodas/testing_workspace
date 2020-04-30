package testing;

import java.io.FileNotFoundException;

interface HasTail { public int getTailLength();
}
 interface HasWhiskers { public int getNumberOfWhiskers();
} interface Seal extends HasTail, HasWhiskers { }

public interface MyInterface {
	static void pring(){
		System.out.println("Hello");
	}
	public static void read() throws FileNotFoundException {}
	
	/*
	default String toString(){
		return "a";
	}*/
}

abstract class Myclass{
 	public abstract void algo();
}

class Animal {
	Myclass var = new Myclass() {
		@Override
		public void algo() {

		}
	};
	protected void jump() {
		System.out.println("Animal");
	}
}