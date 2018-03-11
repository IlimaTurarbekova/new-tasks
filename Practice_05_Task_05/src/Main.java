import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("A:  ");
		long a = scanner.nextInt();
		System.out.print("B:  ");
		long b = scanner.nextInt();
		
		long gcd = euclid_gcd_recursive(a, b);
		System.out.printf("мнд(%d, %d) = %d", a, b, gcd);
	}
	
	public static long slow_gcd(int a, int b) {
		
		long i = Math.min(a, b);
		
		while(i > 0) {
			if(a % i == 0 && b % i == 0) {
				break;
			}
			--i;
		}
		return i;
	}
	
	public static long euclid_gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
			return a;
	}
	
	public static long euclid_gcd_recursive(long a, long b) {
//		if (b != 0) {
//			return euclid_gcd_recursive(b, a % b);
//		} else {
//			return a;
//		}
		return b != 0 ? euclid_gcd_recursive(b,a % b) : a;
	}
}
