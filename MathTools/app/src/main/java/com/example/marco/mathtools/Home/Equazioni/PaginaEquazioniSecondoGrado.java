package com.example.marco.mathtools.Home.Equazioni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marco.mathtools.R;

import java.util.Arrays;

public class PaginaEquazioniSecondoGrado extends AppCompatActivity {
    EditText a, b, c;
    TextView soluzioni, delta;
    EquazioneSecondoGrado e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_equazioni_secondo_grado);
        a = (EditText) findViewById(R.id.a); a.setKeyListener(DigitsKeyListener.getInstance(true, false));
        b = (EditText) findViewById(R.id.b); b.setKeyListener(DigitsKeyListener.getInstance(true, false));
        c = (EditText) findViewById(R.id.c); c.setKeyListener(DigitsKeyListener.getInstance(true, false));
        soluzioni = (TextView) findViewById(R.id.Soluzioni);
        delta = (TextView) findViewById(R.id.Delta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pagina_equazioni_secondo_grado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void CalcolaOnClick(View view) {
        int a = 0, b = 0, c = 0;
        try { a = Integer.parseInt(this.a.getText().toString()); }
        catch(Exception e) { Toast.makeText(getApplicationContext(), "a non valido!", Toast.LENGTH_SHORT); }
        try{ b = Integer.parseInt(this.b.getText().toString()); }
        catch(Exception e) { Toast.makeText(getApplicationContext(), "b non valido!", Toast.LENGTH_SHORT); }
        try {c = Integer.parseInt(this.c.getText().toString()); }
        catch(Exception e) { Toast.makeText(getApplicationContext(), "c non valido!", Toast.LENGTH_SHORT); }
        e = new EquazioneSecondoGrado(a, b, c);
        soluzioni.append(Arrays.toString(e.soluzioni()));
        delta.append(String.valueOf(e.delta()));

    }
}
