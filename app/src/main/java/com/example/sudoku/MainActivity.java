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


        TableLayout tl = new TableLayout(this);

        for (int i = 0; i < 9; i++) {

            //Es crea la fila
            TableRow tr = new TableRow(this);

            //Despres posarem el marge
            TableRow.LayoutParams aParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

            Spinner spinner = new Spinner(this);
            CharSequence[] nombres = {"1","2","3","4","5","6","7","8","9"};
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                    android.R.layout.simple_spinner_item, nombres);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setBackground(null);
            spinner.setAdapter(adapter);

            //Afegim a la fila
            tr.addView(spinner);

            //Afegim la fila a la taula
            tl.addView(tr);
        }

    }
}