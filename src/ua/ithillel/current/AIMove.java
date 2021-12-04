package ua.ithillel.current;

import java.util.Random;

public class AIMove implements Move {
    private static final char AI_SYMBOL = 'O';
    private final Random random = new Random();
    private Field field;

    public AIMove(Field field) {
        this.field = field;
    }

    @Override
    public MoveResult doMove() {
        int vertical = random.nextInt(field.getFieldSize());
        int horizontal = random.nextInt(field.getFieldSize());
        return new MoveResult(AI_SYMBOL, new Coordinate(vertical, horizontal));
    }
}