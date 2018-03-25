import java.util.Scanner;

public class Main {
	private static final int COMMAND_PUT_PEN_DOWN     = 1;
	private static final int COMMAND_PUT_PEN_UP       = 2;
	private static final int COMMAND_TURN_RIGHT       = 3;
	private static final int COMMAND_TURN_LEFT        = 4;
	private static final int COMMAND_GAME_MOVE        = 5;
	private static final int COMMAND_PRINT_GAME_FIELD = 6;
	private static final int COMMAND_EXIT             = 9;
	
	/* Game Field*/
	
	public static final char GAME_FIELD_WIDTH  = 20;
	public static final char GAME_FIELD_HEIGHT = 20;
	
	public static final char GAME_FIELD_EMPTY_CELL  = '.';
	public static final char GAME_FIELD_MARKED_CELL = '*';
	public static final char GAME_FIELD_TURTLE_CELL = 'T';
	
	/* Turtle */
	static int turtleX, turtleY;
	static int turtleDX, turtleDY;
	static boolean isTurtlePenDown;
	
	
	
	/* Game Field*/
	
	public static char[][] createGameField(int width, int height, char emptyCellValue) {
		char[][] gameField = new char[width][height];
		initGameField(gameField, width, height, emptyCellValue);
		
		return gameField ;
	}

	public static void initGameField(char[][] gameField, int width, int height, char emptyCellValue) {
		for(int x = 0; x < width; ++x) {
			for(int y = 0; y < height; ++y) {
				gameField[x][y]= emptyCellValue;
			}
		}
	}
	
	public static String convertGameFieldToString(char[][] gameField, char turtleCellValue) {
		StringBuilder result = new StringBuilder("");
		for(int y = 0; y < gameField.length; ++y) {
			for(int x = 0; x < gameField.length; ++x) {
				if(y == turtleY && x == turtleX) {
					result.append(turtleCellValue);
				} else {
					result.append(gameField[x][y]);
				}
			}
			result.append('\n');
		}
		
		return result.toString();
	}
	
	/* Turtle */
	
	public static void initTurtle() {
		turtleX = turtleY = 0;
		turtleDX = 1;
		turtleDY = 0;
		isTurtlePenDown = false;
	}
	
	public static void putTurtlePenDown() {
		isTurtlePenDown = true;
	}
	
	public static void putTurtlePenUp() {
		isTurtlePenDown = false;
	}
	
	public static void turnTurtleRight() {
		int temp = turtleDX;
		turtleDX = turtleDY;
		turtleDY = temp;
		
		turtleDX *= -1;
	}
	
	public static void turnTurtleLeft() {
		int temp = turtleDX;
		turtleDX = turtleDY;
		turtleDY = temp;
		
		turtleDY *= -1;
	}
	
	public static void moveTurtle(int steps, char[][] gameField, char markedCellValue ) {
		for(int i = 0; i < steps; ++i) {
			int nextX = turtleX + turtleDX;
			int nextY = turtleY + turtleDY;
			if(!(nextX >= 0 && nextX < gameField.length &&
			   nextY >= 0 && nextY < gameField[0].length)) {
			   break;
			} 
			
			if(isTurtlePenDown) {
				gameField[turtleX][turtleY] = markedCellValue;
			}
			
			turtleX = nextX;
		    turtleY = nextY;
		}
	}
	
	/* Entry Point*/
	
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		
		char[][] gameField = 
				createGameField(
						GAME_FIELD_WIDTH,
						GAME_FIELD_HEIGHT, 
						GAME_FIELD_EMPTY_CELL
				);
		initTurtle();
		
		int command;
		while((command= scanner.nextInt()) != COMMAND_EXIT) {
			switch (command) {
				case COMMAND_PUT_PEN_DOWN:
					putTurtlePenDown();
					break;
				case COMMAND_PUT_PEN_UP:
					putTurtlePenUp();
					break;
				case COMMAND_TURN_RIGHT:
					turnTurtleRight();
					break;
				case COMMAND_TURN_LEFT:
					turnTurtleLeft();
					break;
				case COMMAND_GAME_MOVE:
					int steps = scanner.nextInt();
					moveTurtle(steps, gameField, GAME_FIELD_MARKED_CELL);
					break;
				case COMMAND_PRINT_GAME_FIELD:
					System.out.println(
							convertGameFieldToString(
									gameField,
									GAME_FIELD_TURTLE_CELL
							)
					);
					break;
				default:
					System.err.println("Неверная командаю Попробуйте еще раз");
					break;
			}
		}
	}
}
