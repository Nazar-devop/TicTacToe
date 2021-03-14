package com.company;

public class GameRunner {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
        do {
            gameLogic.firstStep();
            gameLogic.analizField();
            gameLogic.showField();
            if (gameLogic.status == gameLogic.winner_x) {
                System.out.println("X WINNER!");
            } else if (gameLogic.status == gameLogic.winner_o) {
                System.out.println("O WINNER!");
            } else if (gameLogic.status == gameLogic.nichiya) {
                System.out.println("NICHIYA");
            }
            gameLogic.activePlayer = (gameLogic.activePlayer.equals(gameLogic.khrestik) ? gameLogic.nulik : gameLogic.khrestik);
        } while (gameLogic.status == gameLogic.trivae);
    }
}
