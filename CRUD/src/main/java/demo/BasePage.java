package demo;

public class BasePage {

	
	public static int getRandomNumber(int max) {
		int min=0;
		int number=(int)(Math.random()*(max-min+1))+min;
		System.out.println("Random Index value is --> "+number);
		return number;
	}
}
