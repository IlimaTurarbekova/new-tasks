import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("N: ");
		int n = scanner.nextInt();
		
		int[] counrters = new int[13];
		for (int i = 0; i < n; ++i) {
			int firstDice = random(1,6);
			int secondDice = random(1,6);
			int sum = firstDice + secondDice;
			++counrters[sum];
		}
		for(int i = 2; i < counrters.length; ++i) {
			System.out.printf("%d: %d%n", i, counrters[i]);
		}

	}
	
	private static int random(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}
