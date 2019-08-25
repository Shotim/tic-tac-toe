package runner;

import scanner.EnterFromConsole;

public class Game {

    private static final int BOT = 1;
    private static final int HUMAN = -1;
    private static final boolean COMPLETE = true;
    private static final boolean INCOMPLETE = false;
    private static final int PLAYER_VS_PLAYER_MODE = 1;
    private static final int PLAYER_VS_COMP_MODE = 2;
    private static final int EXIT = 3;
    public static final int ANGLE = 1;
    public static final int ANY = 2;

    private boolean isRunning = true;

    public void menu() {

        while (isRunning) {
            System.out.println("!!!TIC TAC TOE!!! GAME\n");
            System.out.println("1 - Multiplayer");
            System.out.println("2 - SinglePlayer");
            System.out.println("3 - Exit\n");
            System.out.print("Your choice: ");
            int choice = EnterFromConsole.enterInt();
            switch (choice) {
                case PLAYER_VS_PLAYER_MODE:
                case PLAYER_VS_COMP_MODE:
                    gameMode(choice);
                    break;
                case EXIT:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void gameMode(int gameMode) {

        Cell[][] field = PlayingField.create();
        Player player = new Player();

        boolean exit = false;
        if (gameMode == PLAYER_VS_COMP_MODE) {
            System.out.println("Do you want to go first?\n1 - Yes, I want to be 'X'\n2 - No, I want to be 'O'");
            int choice = EnterFromConsole.enterInt();
            if (choice == 2) {
                player.markTheCell(field[field.length / 2][field.length / 2]);
                player.turnChange();
            }
        }
        while (!exit) {
            PlayingField.illustrate(field);
            player.makeAMove(field);
            exit = exit(field, player);
            if (gameMode == PLAYER_VS_COMP_MODE) {
                gameAlgorithm(field, player);
                exit = exit(field, player);
            }
        }
    }

    private boolean exit(Cell[][] field, Player player) {
        if (winCheck(field)) {
            PlayingField.illustrate(field);
            System.out.println("The winner is the " + player.playerTurn + "-th player!!!\n\n\n");
            return true;
        } else if (PlayingField.isFilled(field)) {
            PlayingField.illustrate(field);
            System.out.println("DRAW!!!\n\n\n");
            return true;
        } else {
            player.turnChange();
            return false;
        }
    }

    private boolean lineIsEquallyFilled(Cell[] line) {
        for (int i = 1; i < line.length; i++) {
            if (line[i].status != line[i - 1].status || line[i].isEmpty()) return false;
        }
        return true;
    }

    private boolean winCheck(Cell[][] field) {
        if (lineIsEquallyFilled(PlayingField.diagonal(field, PlayingField.LEFT))) return true;
        else if (lineIsEquallyFilled(PlayingField.diagonal(field, PlayingField.RIGHT))) return true;
        else {
            for (int i = 0; i < field.length; i++) {
                if (lineIsEquallyFilled(PlayingField.line(field, i, PlayingField.HORIZONTAL))) return true;
                if (lineIsEquallyFilled(PlayingField.line(field, i, PlayingField.VERTICAL))) return true;
            }
        }
        return false;
    }

    private boolean gameAlgorithm(Cell[][] field, Player player) {
        if (findingWinSituation(field, player, BOT)) return COMPLETE;
        else if (findingWinSituation(field, player, HUMAN)) return COMPLETE;
        else if (field[field.length / 2][field.length / 2].isEmpty())
            player.markTheCell(field[field.length / 2][field.length / 2]);
        else if (findingCellToMark(field, player,ANGLE)) return COMPLETE;
        else findingCellToMark(field, player,ANY);
        return COMPLETE;
    }

    private boolean findingWinSituation(Cell[][] field, Player player, int side) {
        if (side == HUMAN) player.turnChange();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].isEmpty()) {
                    player.markTheCell(field[i][j]);
                    if (winCheck(field)) {
                        if (side == HUMAN) {
                            player.turnChange();
                            player.markTheCell(field[i][j]);
                        }
                        return COMPLETE;
                    }
                    player.unmarkTheCell(field[i][j]);
                }
            }
        }
        if (side == HUMAN) player.turnChange();
        return INCOMPLETE;
    }

    private boolean findingCellToMark(Cell[][] field, Player player, int cellType) {
        int step;
        switch (cellType) {
            case ANGLE:
                step = field.length - 1;
                break;
            default:
                step = 1;
                break;
        }
        for (int i = 0; i < field.length; i += step) {
            for (int j = 0; j < field.length; j += step) {
                if (field[i][j].isEmpty()) {
                    player.markTheCell(field[i][j]);
                    return COMPLETE;
                }
            }
        }
        return INCOMPLETE;
    }
}
