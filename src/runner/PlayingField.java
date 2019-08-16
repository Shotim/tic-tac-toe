package runner;

public class PlayingField {
    public static final int RADIX = 3;

    public static Cell[] horizontalLine(Cell[][] field, int indexNumber){
        Cell[] line = new Cell[field.length];
        for (int i = 0; i < line.length; i++) {
            line[i] = field[indexNumber][i];
        }
        return line;
    }

    public static Cell[] verticalLine(Cell[][] field, int indexNumber){
        Cell[] line = new Cell[field.length];
        for (int i = 0; i < line.length; i++) {
            line[i] = field[i][indexNumber];
        }
        return line;
    }

    public static Cell[] leftDiagonal(Cell[][] field){
        Cell[] diagonal = new Cell[field.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = field[i][i];
        }
        return diagonal;
    }

    public static Cell[] rightDiagonal(Cell[][] field){
        Cell[] diagonal = new Cell[field.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = field[i][diagonal.length - 1 - i];
        }
        return diagonal;
    }

    public static Cell[][] create(){
        Cell[][] field = new Cell[RADIX][RADIX];
        for(int i = 0; i < RADIX; i++){
            for(int j = 0; j < RADIX; j++){
                field[i][j] = new Cell();
            }
        }
        return field;
    }

    public static boolean isFilled(Cell[][] field){
        for(int i = 0; i < RADIX; i++){
            for(int j = 0; j < RADIX; j++){
                if(field[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    public static void illustrate(Cell[][] field){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n   0 1 2");
        for (int i = 0; i < RADIX; i++) {
            System.out.print(" "+i+" ");
            for (int j = 0; j < RADIX; j++) {
                field[i][j].illustrate();
            }
            System.out.println();
        }
    }
}
