package com.company;
import java.util.Scanner;

public class GameLogic {
    public Scanner in = new Scanner(System.in);
    Field f1 = new Field();


    int status = f1.getStatusGri();
    int sizeField = f1.getSize();
    String field[][] = f1.getField();
    String activePlayer = f1.getActivePlayer();
    String nul = f1.getNul();
    String khrestik = f1.getKhrestik();
    String nulik = f1.getNulik();
    int winner_x = f1.getWinner_x();
    int winner_o = f1.getWinner_o();
    int nichiya = f1.getNichiya();
    int trivae = f1.getTrivae();


    public void startGame(){
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                field[i][j] = nul;
            }
        }
        activePlayer = khrestik;
        showField();
    }
    public void firstStep(){
        int i = in.nextInt()-1, j = in.nextInt()-1;
        field[i][j] = activePlayer;
    }
    public boolean statusFull(){
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                if (field[i][j].equals(nul)){
                    return false;
                }
            }
        }
        return true;
    }
    public void analizField(){
        String winner = whoWinner();
        if (winner.equals(khrestik)){
            status = winner_x;
        }else if(winner.equals(nulik)){
            status = winner_o;
        }else if (statusFull()){
            status = nichiya;
        }else {
            status = trivae;
        }
    }
    public String whoWinner(){
        int a;
        for (int i = 0; i < sizeField; i++) {                           //
            a=0;                                                      // <-- кількість одинакових елементів
            for (int j = 0; j < sizeField; j++) {                             //
                if (!field[i][0].equals(nul) && field[i][0].equals(field[i][j])){     //     Чи є співпадіння в рядку
                    a++;                                                 //
                }                                                    //
            }                                                    //
            if (a == 3){                                     //
                return field[i][0];                      //
            }                                        //
        }                                        //
        for (int j = 0; j<sizeField; j++){
            a = 0;
            for (int i = 0; i<sizeField;i++){
                if (!field[0][j].equals(nul) && field[0][j].equals(field[i][j])){
                    a++;
                }
            }
            if (a == 3){
                return field[0][j];
            }
        }
        if (!field[0][0].equals(nul) && field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])){
            return field[0][0];
        }
        if (!field[0][2].equals(nul) && field[1][1].equals(field[0][2]) && field[2][0].equals(field[0][2])){
            return field[0][2];
        }
        return nul;
    }
    public  void showField(){
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                System.out.print(field[i][j]);
                if (j != sizeField-1){                // якщо активний стовбець не дорівнює
                    System.out.print("|");       // останньому елементу масива вивести |
                }
            }
            System.out.println();                 //перейти на наступний рядок
            if (i != sizeField-1){
                System.out.println("-----------");// якщо активний рядок не дорівнює
            }                                     // останньому елементу масива вивести --------
        }
        System.out.println();
    }

}