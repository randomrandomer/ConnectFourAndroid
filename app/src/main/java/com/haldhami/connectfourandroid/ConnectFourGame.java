package com.haldhami.connectfourandroid;

import java.util.*;

public class ConnectFourGame {

    Player P1;
    Player P2;
    boolean P1win;
    boolean P2win;

    public void startGame() {
        P1 = new Player();
        P2 = new Player();
        P2.gameMoves = P1.gameMoves;
        P1win = false;
        P2win = false;

        Random rand = new Random();
        int userTurn = rand.nextInt(2);
        //int userTurn = 0;

        /*  Game will change message to tell random player to pick a counter colour.
            Player will be allowed to pick counter colour from two options on the screen.
            Picked option will set each player's counter colour.
        */

        do {
            if (userTurn == 0) {
                System.out.println("Player 1, it is your turn.");   // This will change message at top instead of outputting to console
                P1.takeTurn();
                userTurn = 1;
            } else {
                System.out.println("Player 2, it is your turn.");   // This will change message at top instead of outputting to console
                P2.takeTurn();
                userTurn = 0;
            }
        }
        while (     !(P1.checkWin()) & !(P2.checkWin()) & !(P1.checkDraw())    );

        if (P1.checkWin()) {
            System.out.println("Congratulations Player 1, you have won!");
        } else if (P2.checkWin()) {
            System.out.println("Congratulations Player 2, you have won!");
        } else {
            System.out.println("Game has ended in a draw.");
        }
    }

    public String genMessage(int messageNum) {
        switch (messageNum) {
            case 1:
                return "Player 1, please select the colour of counter you wish to play with.";
            case 2:
                return "Player 2, please select the colour of counter you wish to play with.";
            case 3:
                return "Player 1, it is your turn.";
            case 4:
                return "Player 2, it is your turn.";
            case 5:
                return "Congratulations Player 1, you have won! Would you like to play again?";
            case 6:
                return "Congratulations Player 2, you have won! Would you like to play again?";
            case 7:
                return "The match has ended in a draw as no more moves can be played. Would you like to play again?";
        }
        return null;
    }
}
