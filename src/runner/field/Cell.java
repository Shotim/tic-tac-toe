package runner.field;

public class Cell {

    public int status;

    public static final int X_SIGN = 1;
    public static final int O_SIGN = -1;

    public boolean isEmpty() {
        return status == 0;
    }

    void illustrate() {
        switch (status) {
            case O_SIGN:
                System.out.print("O ");
                break;
            case X_SIGN:
                System.out.print("X ");
                break;
            default:
                System.out.print("# ");
                break;
        }
    }
}
