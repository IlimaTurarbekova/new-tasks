import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� �������� ���������� ");
		int origin = scanner.nextInt();
		System.out.print("������� ������ ����� ");
		int point1 = scanner.nextInt();
		System.out.print("������� ������ ����� ");
		int point2 = scanner.nextInt();

		int distance1 = abs(origin - point1);
		int distance2 = abs(origin - point2);

		int minimumDistance = distance1 < distance2 ? distance1 : distance2;
		/*
		* int minimumDistance;
		* if(distance1 < distance2){
		* 		minimumDistance = distance1;
		* } else {
		* 		minimumDistance = distance2;
		* }
		*/

		if(distance1 < distance2){
			System.out.println(
					"������ ����� ����� ������. ��������� ����� " + minimumDistance
			);
		} else if (distance2 < distance1){
			System.out.println(
					"������ ����� ����� ������. ��������� ����� " + minimumDistance
			);
		} else {
			System.out.println(
					"��� ����� ������������. ��������� ����� " + minimumDistance
			);
		}
	}

	private static int abs(int i) {
		return x < 0 ? -x : x;
	}

//	public class MyMath {
//		return x < 0 ? -x : x;
//	}
}
