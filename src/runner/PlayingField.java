package runner;

public class PlayingField {
    public static final int RADIX = 3;

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
