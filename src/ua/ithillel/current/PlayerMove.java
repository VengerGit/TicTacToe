package ua.ithillel.current;

import java.util.Scanner;

public class PlayerMove implements Move {
    private static final char PLAYER_SYMBOL = 'X';
    private final Scanner scanner = new Scanner(System.in);
    private final Field field;

    public PlayerMove(Field field) {
        this.field = field;
    }

    @Override
    public MoveResult doMove() {
        int vertical = chooseCoordinate('v');
        int horizontal = chooseCoordinate('h');
        return new MoveResult(PLAYER_SYMBOL, new Coordinate(vertical, horizontal));
    }

    private int chooseCoordinate(char coordinateSymbol) {
        int coordinate;

        do {
            System.out.printf("Please enter %s-coordinate [1-%d] ...%n", coordinateSymbol,field.getFieldSize());
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= field.getFieldSize());

        return coordinate;
    }
}