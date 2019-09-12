package runner;

class Cell {

    int status;

    static final int X_SIGN = 1;
    static final int O_SIGN = -1;

    boolean isEmpty() {
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
