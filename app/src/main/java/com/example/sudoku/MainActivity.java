package com.example.sudoku;

import java.util.ArrayList;

public class SudokuModel {

    int sudoku [][] = new int [9][9];

    public void setVal(int x, int y, int numero) {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                        sudoku[x][y] = numero;
            }
        }
    }

    public int getVal(int x, int y) {
        return sudoku[x][y];
    }

    public boolean checkRow(int filaRevisar,int columna, int number, boolean correct) {
        for (int i = 0; i<sudoku[filaRevisar].length; i++){
            //Comprovar que estiguen revisant el numero de la columna que toca
            if (number==sudoku[filaRevisar][i] && sudoku[filaRevisar][i]!=0){
                if (i!=columna)
                    correct=false;
            }
        }



        return correct;
    }

    public boolean checkCol(int fila,int columnaRevisar, int number, boolean correct) {
        for (int i = 0; i<sudoku.length; i++){
            //Comprovar que estiguen revisant el numero de la fila que toca
            if (number==sudoku[i][columnaRevisar] && sudoku[i][columnaRevisar]!=0){
                if (i!=fila)
                    correct=false;
            }
        }



        return correct;
    }

    //La fila que revisarem, la columna que revisarem i amb quin numero volem comprobarho
    public boolean checkGeneral(int fila, int col, int number) {
        boolean correct = true;

        correct = checkRow(fila,col,number,correct);
        correct = checkCol(fila,col,number,correct);

        return correct;
    }

}
