import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("������� ����� �����: ");
		int number = scanner.nextInt();
		
		int sum = 0;
		do {
			sum += number % 10;
			number /= 10;
			
		} while (number != 0);
		
			System.out.printf("����� ���� ��� ���� ����� %d%n", sum);
				
	}

}
