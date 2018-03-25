import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

    /* Commands */

   
            default:
                throw new IllegalArgumentException("Неверный код команды");
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
                throw new IllegalArgumentException("команда должна быть числом");
            } catch(NoSuchElementException e) {
                throw new IllegalArgumentException("команда не была введена");
            }

            if (command == COMMAND_MOVE) {
                try {
                    steps = lineScanner.nextInt();
                } catch(InputMismatchException e) {
                    throw new IllegalArgumentException("количество шагов должно быть числом");
                } catch(NoSuchElementException e) {
                    throw new IllegalArgumentException("количество шагов не введено");
                }

                if (steps < 0) {
                    throw new IllegalArgumentException("количество шагов не может быть отрицательным");
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
         * Измените программу добавив вторую черепашку на поле
         */

        try {
            processInput(scanner);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
