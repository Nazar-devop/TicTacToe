package com.company;

public class Field {

    private final String[][] field = new String[3][3];

    public String[][] getField() {
        return field;
    }
    public void setFieldValue(int indexX, int indexY, String value) {
        field[indexX][indexY] = value;
    }
}
