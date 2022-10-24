package com.example.sudoku;

public class SudokuModel {

    int sudoku [][] = new int [9][9];

    public void setVal(int x, int y) {
    }

    public int getVal() {
        return 0;
    }

    public void creaPartida() {
        //La partida s ha de crear un cop tinguem per a controlar les files i columnes

        //Primerament tindrem una quantitat inicial a la qual l haurem de restar
        int quantitat = 20;

        //Per a fer l emplenat mes aleatori, generarem uns quants, primer per a saber a quina posicio i despres quina quantitat


        while (quantitat > 0) {

            int quadrant = (int) (Math.random() * (8) + 0);
            int posicio = (int) (Math.random() * (8) + 0);
            int numero = (int) (Math.random() * (9-1) + 1);;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (quadrant == i) {
                        if (posicio == j) {
                            sudoku[i][j] = numero;
                        }
                    }
                }
            }
            quantitat--;
        }

    }

}
