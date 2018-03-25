import java.util.Scanner;

public class Main {
	static final int[] DAYS = {
			0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
//month:	   1   2   3   4   5   6  7   8   9   10  11  12
	};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("N:  ");
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; ++i) {
			System.out.print("Введите элемент " + i + ": ");
			numbers[i] =  scanner.nextInt();
		}
		
		System.out.print("До:  ");
		printNumbers(numbers);
		
		reverse(numbers);
		
		System.out.print("После:  ");
		printNumbers(numbers);
	}
	
	

		
	public static void reverse(int[] numbers) {
		for(int i = 0, end = numbers.length / 2; i < end; ++i) {
			int temp = numbers[i];
			numbers[i] = numbers[numbers.length -i -1];
			numbers[numbers.length - i - 1] = temp;
		}
	}
	
	public static void printNumbers(int[] numbers) {
		for(int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i] + (i == numbers.length - 1 ? "\n" : " "));
//			if(i == numbers.length; ++i) {
//				System.out.print(numbers[i]);
//			} else {
//				System.out.print(numbers[i] + " ");
//			}
			
		}
	}
	
}