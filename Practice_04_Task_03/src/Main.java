import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("������� ���������� ������: ");
		int testCount = scanner.nextInt();
		if( testCount < 0) {
			System.err.println("�������� ���������� ������");
			System.exit(-1);
		}
		
		int correctAnswers   = 0;
		int incorrectAnswers = 0;
		
		while (testCount-- > 0) {
			int firstOperand  = random();
			int secondOperand = random();
			
			System.out.print(
					secondOperand < 0 ?
						String.format("%d + %d = ", firstOperand, secondOperand) :
						String.format("%d + %d = ", firstOperand, secondOperand)
			);
			int answer = scanner.nextInt();
			
			if (firstOperand + secondOperand == answer) {
				++correctAnswers;
			} else {
				++incorrectAnswers;
			}
			
		}
		System.out.println("���������� ���������� �������: " + correctAnswers);
		System.out.println("���������� ������������ �������: " + incorrectAnswers);
	}
	
	public static int random() {
		final int MIN_TEST_VALUE = -10;
		final int MAX_TEST_VALUE = 10;
		
		return random(MIN_TEST_VALUE, MAX_TEST_VALUE);
	}
	
	public static int random (int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
		
		
		
		
		
//		int tests = scanner.nextInt();
//		
//		int correctAnswers = 0;
//		int incorrectAnswers = 0;
//		
//		for (int i = 0; i < tests; ++i) {
//			int firstOperand = (int) (MIN + Math.random() * (MAX - MIN + 1));
//			int secondOperand = (int) (MIN + Math.random() * (MAX - MIN + 1));
//			
//			System.out.printf("%d + %d = ", firstOperand, secondOperand);
//			int answer = scanner.nextInt();
//			
//			if (firstOperand + secondOperand == answer) {
//				++correctAnswers;
//			} else {
//				++incorrectAnswers;
//			}
//		}
//		 
//		System.out.printf("���������� ���������� �������: %d%n" +
//						  "���������� ������������ �������: %d%n",
//						  correctAnswers, incorrectAnswers
//		);
		
//	}

	

}
