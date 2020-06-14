package com.haldhami.connectfourandroid;

public class Player {

    int rowSize = 6; //6
    int colSize = 7; //7
    boolean[][] playerMoves = new boolean[rowSize][colSize];
    boolean[][] gameMoves = new boolean[rowSize][colSize];
    String userRow;
    String userColumn;
    int row;
    int column;
    int moveCount;
    int trueCount;
    boolean legal;

    public void takeTurn() {

        /*  This must be changed to display messages to user on screen instead of console.
            At this point, user is allowed to touch screen and touching screen places a counter
            of the chosen colour on the screen. Letting go of the counter over a column will
            check if the move can be played, and if it can then will drop the counter to the
            lowest possible position on the board. This will then change the corresponding element
            of the playerMoves and gameMoves arrays. The method will then end.
         */

        /*do {
            System.out.println("Please enter the row where you would like to place your counter.");
            userRow = userInput.nextLine();
            System.out.println("Please enter the column where you would like to place your counter.");
            userColumn = userInput.nextLine();
            System.out.println("");
            row = Integer.parseInt(userRow);
            column = Integer.parseInt(userColumn);
            if (!(gameMoves[row][column])){
                legal = true;
            }
            if (!legal) {
                System.out.println("That move cannot be made. A counter is already in that position.");
            }

        } while (!legal);*/


        playerMoves[row][column] = true;
        gameMoves[row][column] = true;
        legal = false;
        moveCount++;

    }

    // Following method should remain unchanged

    public boolean checkWin() {

        if (moveCount < 4) {
            return false;
        }

        trueCount = 0;
        int i = 0;
        int j = 0;

        // First loop checking column by looping down column
        for (i = 0; i < rowSize; i++) {
            if (playerMoves[i][column]) {
                trueCount++;
                if (trueCount == 4) {
                    return true;
                }
            } else {
                trueCount = 0;
            }
        }

        // Second loop checking row by along row
        for (j = 0; j < colSize; j++) {
            if (playerMoves[row][j]) {
                trueCount++;
                if (trueCount == 4) {
                    return true;
                }
            } else {
                trueCount = 0;
            }
        }

        // Third loop checking upper left - lower right diagonal
        if (row > column) {
            i = row - column;
            j = 0;
        } else {
            i = 0;
            j = column - row;
        }

        for (; (i < rowSize) && (j < colSize); i++, j++) {
            if (playerMoves[i][j]) {
                trueCount++;
                if (trueCount == 4) {
                    return true;
                }
            } else {
                trueCount = 0;
            }
        }

        // Fourth loop checking lower left - upper right diagonal
        if ((5 - row) > column) {
            i = row + column;
            j = 0;
        } else if ((5 - row) < column) {
            i = 5;
            j = column - row;
        } else {
            i = 5;
            j = 0;
        }

        for (; (i > -1) && (j < colSize); i--, j++) {
            if (playerMoves[i][j]) {
                trueCount++;
                if (trueCount == 4) {
                    return true;
                }
            } else {
                trueCount = 0;
            }
        }

        return false;

    }

    public boolean checkDraw() {

        int i;
        int j;

        for (boolean[] bb : gameMoves) {
            for (boolean b: bb) {
                if (!b) return false;
            }
        }
        return true;
    }

}
