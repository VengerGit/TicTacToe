package ua.ithillel.current;

import java.util.Scanner;

public class Field {
    private static final char EMPTY_SYMBOL = '-';
    private final char[][] field;
    private int fieldSize;

    public Field() {
        int maxFieldSize = 11;
        do {
            System.out.println("enter field size [3-10]");
            Scanner scanner = new Scanner(System.in);
            this.fieldSize = scanner.nextInt();
        } while (fieldSize < 3 || fieldSize >= maxFieldSize);
        this.field = new char[fieldSize][fieldSize];
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void initField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    public void printField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean isFreeField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == EMPTY_SYMBOL) {
                    return false;
                }
            }
        }
        return true;
    }

    public char doMove(Move move) {
        MoveResult moveResult;
        Coordinate coordinate;

        do {
            moveResult = move.doMove();
            coordinate = moveResult.getCoordinate();
        } while (field[coordinate.getVertical()][coordinate.getHorizontal()] != EMPTY_SYMBOL);

        return field[coordinate.getVertical()][coordinate.getHorizontal()] = moveResult.getSymbol();
    }

    public boolean checkWinner(char symbol) {
        for (int i = 0; i < fieldSize; i++) {
            int result = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == symbol) {
                    result++;
                }
                if (result == fieldSize) {
                    return true;
                }
            }
        }
        for (int j = 0; j < fieldSize; j++) {
            int result = 0;
            for (int i = 0; i < fieldSize; i++) {
                if (field[i][j] == symbol) {
                    result++;
                }
                if (result == fieldSize) {
                    return true;
                }
            }
        }
        int first = 0;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (j == i && field[i][j] == symbol) {
                    first++;
                }
            }
            if (first == fieldSize) {
                return true;
            }
        }
        int second = 0;
        for (int i = 0, j = fieldSize - 1; i < fieldSize && j >= 0; i++, j--) {
            if (field[i][j] == symbol) {
                second++;
            }
            if (second == fieldSize) {
                return true;
            }
        }
        return false;
    }
}