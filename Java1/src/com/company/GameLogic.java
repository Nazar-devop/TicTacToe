package com.company;
import java.util.Scanner;

public class GameLogic {
    int statusGri;
    int size = 3;
    String activePlayer;
    String nul = "   ", khrestik = " X ", nulik = " O ";
    int trivae = 0, nichiya = 1, winner_x = 2, winner_o = 3;
    public Scanner in = new Scanner(System.in);

    Field f1 = new Field();

    public void showField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(f1.getField()[i][j]);
                if (j != size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != size - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println("Зделайте ваш ход: ");
    }
    public void startGame() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                f1.getField()[i][j] = nul;
            }
        }
        activePlayer = khrestik;
        showField();
        do {
            firstStep();
            analizField();
            showField();
            if (statusGri == winner_x) {
                System.out.println("X WINNER!");
            } else if (statusGri == winner_o) {
                System.out.println("O WINNER!");
            } else if (statusGri == nichiya) {
                System.out.println("NICHIYA");
            }
            activePlayer = (activePlayer.equals(khrestik) ? nulik : khrestik);
        } while (statusGri == trivae);
    }
    public void firstStep() {
        int i = in.nextInt() - 1, j = in.nextInt() - 1;
        f1.setFieldValue(i,j,activePlayer);
    }
    public boolean statusFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (f1.getField()[i][j].equals(nul)) {
                    return false;
                }
            }
        }
        return true;
    }
    public void analizField() {
        String winner = whoWinner();
        if (winner.equals(khrestik)) {
            statusGri = winner_x;
        } else if (winner.equals(nulik)) {
            statusGri = winner_o;
        } else if (statusFull()) {
            statusGri = nichiya;
        } else {
            statusGri = trivae;
        }
    }
    public String whoWinner() {
        int a;
        for (int i = 0; i < size; i++) {
            a = 0;
            for (int j = 0; j < size; j++) {
                if (!f1.getField()[i][0].equals(nul) && f1.getField()[i][0].equals(f1.getField()[i][j])) {
                    a++;
                }
            }
            if (a == 3) {
                return f1.getField()[i][0];
            }
        }
        for (int j = 0; j < size; j++) {
            a = 0;
            for (int i = 0; i < size; i++) {
                if (!f1.getField()[0][j].equals(nul) && f1.getField()[0][j].equals(f1.getField()[i][j])) {
                    a++;
                }
            }
            if (a == 3) {
                return f1.getField()[0][j];
            }
        }
        if (!f1.getField()[0][0].equals(nul) && f1.getField()[0][0].equals(f1.getField()[1][1]) && f1.getField()[0][0].equals(f1.getField()[2][2])) {
            return f1.getField()[0][0];
        }
        if (!f1.getField()[0][2].equals(nul) && f1.getField()[1][1].equals(f1.getField()[0][2]) && f1.getField()[2][0].equals(f1.getField()[0][2])) {
            return f1.getField()[0][2];
        }
        return nul;
    }

}