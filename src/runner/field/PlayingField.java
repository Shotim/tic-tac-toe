package runner.field;

import runner.field.Cell;

public class PlayingField {

    private static final int RADIX = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;


    public static Cell[] line(Cell[][] field, int indexNumber, int lineType) {
        Cell[] line = new Cell[field.length];
        for (int i = 0; i < line.length; i++) {
            switch (lineType) {
                case HORIZONTAL:
                    line[i] = field[indexNumber][i];
                    break;
                case VERTICAL:
                    line[i] = field[i][indexNumber];
                    break;
            }
        }
        return line;
    }

    public static Cell[] diagonal(Cell[][] field, int diagonalType) {
        Cell[] diagonal = new Cell[field.length];
        for (int i = 0; i < diagonal.length; i++) {
            switch (diagonalType) {
                case LEFT:
                    diagonal[i] = field[i][i];
                    break;
                case RIGHT:
                    diagonal[i] = field[i][diagonal.length - 1 - i];
                    break;
            }
        }
        return diagonal;
    }

    public static Cell[][] create() {
        Cell[][] field = new Cell[RADIX][RADIX];
        for (int i = 0; i < RADIX; i++) {
            for (int j = 0; j < RADIX; j++) {
                field[i][j] = new Cell();
            }
        }
        return field;
    }

    public static boolean isFilled(Cell[][] field) {
        for (int i = 0; i < RADIX; i++) {
            for (int j = 0; j < RADIX; j++) {
                if (field[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    public static void illustrate(Cell[][] field) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n   0 1 2");
        for (int i = 0; i < RADIX; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < RADIX; j++) {
                field[i][j].illustrate();
            }
            System.out.println();
        }
    }
}
