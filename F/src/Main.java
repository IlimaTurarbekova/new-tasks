import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        
        int palindromes = 0;
        for (int n = 1; n <= k; ++n) {
        	int temp = n, reversed = 0, digit = 0;
            do {
            	temp /= 10;
                ++digit;
            } while (temp > 0);
            
            int m = 1; for(int i = 0; i < digit - 1; ++i) m *= 10; 
            
            temp = n;
            do {
            	reversed += temp % 10 * m;
            	m    /= 10;
            	temp /= 10;
            } while(temp > 0);
            
            if (n ==reversed) {
            	++palindromes;
            }
        }
    	
        
        System.out.println(palindromes);
    }
 
}