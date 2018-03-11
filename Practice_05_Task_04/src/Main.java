import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("A:  ");
		int a = scanner.nextInt();
		System.out.print("B:  ");
		int b = scanner.nextInt();
		
		int gcd = gcd(a, b);
		System.out.printf("мнд(%d, %d) = %d", a, b, gcd);
	}
	
	public static int gcd(int a, int b) {
//		int start = Math.min(a, b);
		
//		int i;
//		for (i = start; i > 0; --i) {
//			if(a % i == 0 && b % i == 0) {
//				break;
//			}
//		}
		
//		return i;
		
//		int i;
//		for (i = start; i > 0; --i) {
//			if(a % i == 0 && b % i == 0) {
//				break;
//			}
//		}
		
//		return i;
		
		int i = Math.min(a, b);
		
		while(i > 0) {
			if(a % i == 0 && b % i == 0) {
				break;
			}
			--i;
		}
		return i;
	}
}
