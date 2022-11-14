package com.example.sudoku_casa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerList [][] = new Spinner[9][9];
    SudokuModel sm = new SudokuModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] numero = {"0","1","2","3","4","5","6","7","8","9"};
        TableLayout tl = findViewById(R.id.tableLayout);
        for (int fila = 0; fila < 9; fila++) {
            //Es crea la fila

            TableRow tr = new TableRow(this);
            for (int col = 0; col < 9; col++) {


                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);
                spinner.setTag(R.id.fila,fila);
                spinner.setTag(R.id.col,col);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, numero);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setOnItemSelectedListener(
                        new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> spn,
                                                       android.view.View v,
                                                       int posicion,
                                                       long id) {
                                int filaSpinner = (int) spn.getTag(R.id.fila);
                                int colSpinner = (int) spn.getTag(R.id.col);

                                actualitzarApp();
                                Spinner numSpinner = spinnerList[filaSpinner][colSpinner];
                                //Intentar actualizarlo con lo del setTag
                                boolean correcto = sm.checkGeneral(filaSpinner,colSpinner,numSpinner.getSelectedItemPosition());

                                if (correcto == false) {
                                    spinner.setBackgroundColor(Color.RED);
                                    Log.v("MAL","ReMal");
                                }
                                else {
                                    sm.setVal(filaSpinner,colSpinner, spn.getSelectedItemPosition());
                                }
                            }

                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }

                        });

                spinner.setAdapter(adapter);

                //Afegim a la fila
                tr.addView(spinner);
                spinnerList[fila][col] = spinner;

            }
            //Afegim la fila a la taula
            tl.addView(tr);
        }




        creaPartida();
    }
    public void creaPartida() {
        //La partida s ha de crear un cop tinguem per a controlar les files i columnes

        //Primerament tindrem una quantitat inicial a la qual l haurem de restar
        int quantitat = 20;

        while (quantitat > 0) {

            int fila = (int) (Math.random() * (9) + 0);
            int columna = (int) (Math.random() * (9) + 0);
            int numero = (int) (Math.random() * (9 - 1) + 1);



            //Comprovar que no hi hagi un numero previament
            if (spinnerList[fila][columna].getSelectedItem().toString() == "0") {
                spinnerList[fila][columna].setSelection(numero);
                sm.setVal(fila,columna,numero);
            } else {
                //Si hi ha el numero el que farem sera augmentar una pasada per a
                //que segueixi fent
                quantitat++;
                }
            quantitat--;

        }

    }

    public void actualitzarApp() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                spinnerList[i][j].setSelection(sm.getVal(i,j));
            }
        }
    }




}
