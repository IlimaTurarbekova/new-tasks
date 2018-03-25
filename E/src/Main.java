import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

    	int temp = n, result = 0, digit = 0;
      
        do {
        	temp /= 10;
            ++digit;
        } while (temp > 0);
        
       temp = n;
        do {
        	--digit;
        	int m = 1; for(int i = 0; i < digit; ++i) m *= 10;
        	result += temp % 10 * m;
        	temp /= 10;
        } while(temp > 0);
        
        System.out.println(result);
    }
 
}