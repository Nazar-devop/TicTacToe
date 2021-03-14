package com.company;

public class Field {
    private  int statusGri;
    private int size = 3;
    private String activePlayer;
    private String[][] field = new String[size][size];
    private String nul = "   ", khrestik = " X ", nulik = " O ";
    private int trivae = 0, nichiya = 1, winner_x = 2, winner_o = 3;

    public Field() {
    }

    public int getTrivae() {
        return trivae;
    }

    public void setTrivae(int trivae) {
        this.trivae = trivae;
    }

    public int getNichiya() {
        return nichiya;
    }

    public void setNichiya(int nichiya) {
        this.nichiya = nichiya;
    }

    public int getWinner_x() {
        return winner_x;
    }

    public void setWinner_x(int winner_x) {
        this.winner_x = winner_x;
    }

    public int getWinner_o() {
        return winner_o;
    }

    public void setWinner_o(int winner_o) {
        this.winner_o = winner_o;
    }

    public String getNulik() {
        return nulik;
    }

    public void setNulik(String nulik) {
        this.nulik = nulik;
    }

    public String getKhrestik() {
        return khrestik;
    }

    public void setKhrestik(String khrestik) {
        this.khrestik = khrestik;
    }

    public String getNul() {
        return nul;
    }

    public void setNul(String nul) {
        this.nul = nul;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStatusGri() {
        return statusGri;
    }

    public void setStatusGri(int statusGri) {
        this.statusGri = statusGri;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public String[][] getField() {
        return field;
    }

    public void setField(String[][] field) {
        this.field = field;
    }
}
