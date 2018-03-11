import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final int MIN = 0;
		final int MAX = 100;
		
		System.out.print("������� ���������� ������: ");
		int tests = scanner.nextInt();
		
		int correctAnswers = 0;
		int incorrectAnswers = 0;
		
		for (int i = 0; i < tests; ++i) {
			int firstOperand = (int) (MIN + Math.random() * (MAX - MIN + 1));
			int secondOperand = (int) (MIN + Math.random() * (MAX - MIN + 1));
			
			System.out.printf("%d + %d = ", firstOperand, secondOperand);
			int answer = scanner.nextInt();
			
			if (firstOperand + secondOperand == answer) {
				++correctAnswers;
			} else {
				++incorrectAnswers;
			}
		}
		 
		System.out.printf("���������� ���������� �������: %d%n" +
						  "���������� ������������ �������: %d%n",
						  correctAnswers, incorrectAnswers
		);
	}

}
