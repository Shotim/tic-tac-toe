package runner;

import scanner.EnterFromConsole;

class Player {
    private static final int FIRST = 1;
    private static final int SECOND = 2;


    int playerTurn;

    Player() {
        playerTurn = FIRST;
    }

    void turnChange() {
        playerTurn = (playerTurn == FIRST) ? SECOND : FIRST;
    }

    void markTheCell(Cell cell) {
        cell.status = (playerTurn == FIRST) ? Cell.X_SIGN : Cell.O_SIGN;
    }

    void unmarkTheCell(Cell cell) {
        cell.status = 0;
    }

    void makeAMove(Cell[][] field) {
        boolean canBeSigned = false;

        System.out.println("The " + playerTurn + "-th player, your turn!");

        while (!canBeSigned) {
            int[] coordinates = EnterFromConsole.enterCoordinates();
            if (field[coordinates[0]][coordinates[1]].isEmpty()) {
                canBeSigned = true;
                markTheCell(field[coordinates[0]][coordinates[1]]);
            } else {
                System.out.println("You can't sign the cell that is already signed!!!");
                System.out.println("Type coordinates again!!!");
            }
        }
    }
}
