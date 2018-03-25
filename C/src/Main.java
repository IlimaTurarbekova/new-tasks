import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int min = 9;
        int max = 0;
        
        do {
        	int digit = n % 10;
        	if(digit > max) {
        		max = digit;
        	}
        	if(digit < min) {
        		min = digit;
        	}
        	n /= 10;
        } while(n > 0);
        System.out.printf("%d %d%n", min, max);
    }
}
 