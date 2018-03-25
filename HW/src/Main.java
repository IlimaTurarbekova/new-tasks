import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

    /* Commands */

   
            default:
                throw new IllegalArgumentException("�������� ��� �������");
        }
    }

    private static void processInput(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            int command; int steps = 0;
            try {
                command = lineScanner.nextInt();
            } catch(InputMismatchException e) {
                throw new IllegalArgumentException("������� ������ ���� ������");
            } catch(NoSuchElementException e) {
                throw new IllegalArgumentException("������� �� ���� �������");
            }

            if (command == COMMAND_MOVE) {
                try {
                    steps = lineScanner.nextInt();
                } catch(InputMismatchException e) {
                    throw new IllegalArgumentException("���������� ����� ������ ���� ������");
                } catch(NoSuchElementException e) {
                    throw new IllegalArgumentException("���������� ����� �� �������");
                }

                if (steps < 0) {
                    throw new IllegalArgumentException("���������� ����� �� ����� ���� �������������");
                }
            }

            if (command != COMMAND_MOVE) {
                processCommand(new int[] { command });
            } else {
                processCommand(new int[] { command, steps });
            }
        }
    }

   

        /*
         * �������� ��������� ������� ������ ��������� �� ����
         */

        try {
            processInput(scanner);
        } catch (Exception e) {
            System.out.println("������: " + e.getMessage());
        }
    }

}
