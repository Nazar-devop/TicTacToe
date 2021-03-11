package MyProject;
import java.util.Scanner;

class Field{
    public static int statusGri;
    public static final int SIZE = 3;
    public static String activePlayer;
    public static Scanner in = new Scanner(System.in);
    public static String[][] field = new String[SIZE][SIZE];
    public static final String NULL = "   ", KHRESTIK = " X ", NULIK = " O ";
    public static final int GRA_TRIVAE = 0, NICHIYA = 1, WINNER_X = 2, WINNER_O = 3;
}

class GameLogic extends Field{
   public static void ShowField(){
       for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               System.out.print(field[i][j]);
               if (j != SIZE-1){
                   System.out.print("|");
               }
           }
           System.out.println();
           if (i != SIZE-1){
               System.out.println("-----------");
           }
       }
       System.out.println();
   }
   public static void StartGame(){
       for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               field[i][j] = NULL;
           }
       }
       activePlayer = KHRESTIK;
       ShowField();
   }
   public static void FirstStep(){
       int i = in.nextInt()-1, j = in.nextInt()-1;
       field[i][j] = activePlayer;
   }
   public static boolean StatusFull(){
       for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               if (field[i][j] == NULL){
                   return false;
               }
           }
       }
       return true;
   }
   public static void AnalizField(){
       String winner = WhoWinner();
       if (winner.equals(KHRESTIK)){
           statusGri = WINNER_X;
       }else if(winner.equals(NULIK)){
           statusGri = WINNER_O;
       }else if (StatusFull()){
           statusGri = NICHIYA;
       }else {
           statusGri = GRA_TRIVAE;
       }
   }
   public static String WhoWinner(){
       int a;
       for (int i = 0; i < SIZE; i++) {
           a=0;
           for (int j = 0; j < SIZE; j++) {
               if (field[i][0] != NULL && field[i][0] == field[i][j]){
                   a++;
               }
           }
           if (a == 3){
               return field[i][0];
           }
       }
       for (int j = 0; j<SIZE; j++){
           a = 0;
           for (int i = 0; i<SIZE;i++){
               if (field[0][j] != NULL && field[0][j] == field[i][j]){
                   a++;
               }
           }
           if (a == 3){
               return field[0][j];
           }
       }
       if (field[0][0] != NULL && field[0][0] == field[1][1] && field[0][0] == field[2][2]){
           return field[0][0];
       }
       if (field[0][2] != NULL && field[1][1] == field[0][2] && field[2][0] == field[0][2]){
           return field[0][2];
       }
       return NULL;
   }
}

public class GameRunner extends GameLogic {
    public static void main(String[] args) {
        StartGame();
        do {
            FirstStep();
            AnalizField();
            ShowField();
            if (statusGri == WINNER_X){
                System.out.println("X WINNER!");
            }
            else if (statusGri == WINNER_O){
                System.out.println("O WINNER!");
            }
            else if(statusGri == NICHIYA) {
                System.out.println("NICHIYA");
            }
            activePlayer = (activePlayer == KHRESTIK?NULIK:KHRESTIK);
        }while (statusGri == GRA_TRIVAE);
    }
}