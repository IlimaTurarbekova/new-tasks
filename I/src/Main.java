import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        
        int k = 0;
        for (int i = 1, end = (int) Math.sqrt(x); i <= end; ++i){
            if (x % i == 0){
            	if(x / i == i) {
            		++k;
            	} else {
            		k += 2;
            	}
            }
        }
        System.out.println(k);
    }
}
 
