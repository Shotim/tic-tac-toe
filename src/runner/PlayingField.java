package runner;

class PlayingField {
    private static final int RADIX = 3;
    static final int HORIZONTAL = 1;
    static final int VERTICAL = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;


    static Cell[] line(Cell[][] field, int indexNumber, int lineType) {
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

    static Cell[] diagonal(Cell[][] field, int diagonalType) {
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

    static Cell[][] create() {
        Cell[][] field = new Cell[RADIX][RADIX];
        for (int i = 0; i < RADIX; i++) {
            for (int j = 0; j < RADIX; j++) {
                field[i][j] = new Cell();
            }
        }
        return field;
    }

    static boolean isFilled(Cell[][] field) {
        for (int i = 0; i < RADIX; i++) {
            for (int j = 0; j < RADIX; j++) {
                if (field[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    static void illustrate(Cell[][] field) {
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
