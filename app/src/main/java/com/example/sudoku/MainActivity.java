package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] nombres = {"1","2","3","4","5","6","7","8","9"};
        TableLayout tl = findViewById(R.id.tableLayout);
        Spinner spinnerList [][] = new Spinner[9][9];
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
                    android.R.layout.simple_spinner_item, nombres);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


            spinner.setAdapter(adapter);

            //Afegim a la fila
            tr.addView(spinner);

            }
            //Afegim la fila a la taula
            tl.addView(tr);
        }

    }
}