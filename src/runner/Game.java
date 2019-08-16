package runner;

import scanner.EnterFromConsole;

public class Game {

    boolean isRunning = true;

    public void menu() {

        while (isRunning) {
            System.out.println("!!!TIC TAC TOE!!! GAME\n");
            System.out.println("1 - Multiplayer");
            System.out.println("2 - SinglePlayer");
            System.out.println("3 - Exit\n");
            System.out.print("Your choice: ");
            switch (EnterFromConsole.enterInt()) {
                case 1:
                    gameModePlayerVSPlayer();
                    break;
                case 2:
                    gameModePlayerVSComp();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    void gameModePlayerVSPlayer() {

        Cell[][] field = PlayingField.create();
        Player player = new Player();

        boolean exit = false;
        while (!exit) {
            PlayingField.illustrate(field);
            player.makeAMove(field);
            if (winCheck(field)) {
                exit = true;
                PlayingField.illustrate(field);
                System.out.println("The winner is the " + player.playerTurn + "-th player!!!\n\n\n");
            } else if (PlayingField.isFilled(field)) {
                exit = true;
                PlayingField.illustrate(field);
                System.out.println("DRAW!!!\n\n\n");
            } else player.turnChange();
        }
    }

    void gameModePlayerVSComp() {
        Cell[][] field = PlayingField.create();
    }

    boolean lineIsEquallyFilled(Cell[] line) {
        for (int i = 1; i < line.length; i++) {
            if (line[i].status != line[i - 1].status || line[i].isEmpty()) return false;
        }
        return true;
    }

    /*boolean lineIsEquallyFilled(Cell cell1,Cell cell2,Cell cell3){
        return cell1.status==cell2.status && cell2.status==cell3.status && !cell3.isEmpty();
    }*/

    boolean winCheck(Cell[][] field) {
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

    /*boolean winCheck(Cell[][] field){
        if(lineIsEquallyFilled(field[0][0],field[1][1],field[2][2])) return true;
        else if(lineIsEquallyFilled(field[2][0],field[1][1],field[0][2])) return true;
        else{
            for (int i = 0; i < RADIX ; i++) {
                if(lineIsEquallyFilled(field[i][0],field[i][1],field[i][2]))return true;
                if(lineIsEquallyFilled(field[0][i],field[1][i],field[2][i]))return true;
            }
        }
        return false;
    }*/


}
