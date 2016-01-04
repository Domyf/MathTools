package com.example.marco.mathtools.Home.FunzioniBase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marco.mathtools.Home.Logaritmo;
import com.example.marco.mathtools.R;

import org.w3c.dom.Text;

public class PaginaLogaritmi extends AppCompatActivity {

    EditText a,b,x;

    Logaritmo l;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_logaritmi);
        l = new Logaritmo();
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        x = (EditText) findViewById(R.id.x);

        toast = new Toast(getApplicationContext());
        a.setKeyListener(DigitsKeyListener.getInstance(false,true));
        b.setKeyListener(DigitsKeyListener.getInstance(true,true));
        x.setKeyListener(DigitsKeyListener.getInstance(true, true));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pagina_logaritmi, menu);
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
    public void Calcola(View view){
       if(this.a.getText().toString().isEmpty()) {
            if(this.b.getText().toString().isEmpty() || this.x.getText().toString().isEmpty())
                toast.makeText(getApplicationContext(), "Sono necessari due numeri!", Toast.LENGTH_SHORT).show();
            else{
                try { double b = Double.parseDouble(this.b.getText().toString()); }
                catch(Exception e) { toast.makeText(getApplicationContext(), "b non valido!", Toast.LENGTH_SHORT); }
                try{ double x = Double.parseDouble(this.x.getText().toString()); }
                catch(Exception e) { toast.makeText(getApplicationContext(), "x non valido!", Toast.LENGTH_SHORT); }
            }
        }
        else if(this.b.getText().toString().isEmpty()) {

        }
        else if(this.x.getText().toString().isEmpty()) { //Calcolo X
           boolean errore = false;
            if(this.a.getText().toString().isEmpty() || this.b.getText().toString().isEmpty()){
                toast.makeText(getApplicationContext(), "Sono necessari due numeri!", Toast.LENGTH_SHORT).show();  errore = true; }
            else{

                double a = 0, b = 0;
                try { a = Double.parseDouble(this.a.getText().toString()); }
                catch(Exception e) { toast.makeText(getApplicationContext(), "a non valido!", Toast.LENGTH_SHORT).show(); errore = true; }
                try{ b = Double.parseDouble(this.b.getText().toString()); }
                catch(Exception e) { toast.makeText(getApplicationContext(), "b non valido!", Toast.LENGTH_SHORT); errore = true; }
                if(a<0) { toast.makeText(getApplicationContext(), "La base deve essere maggiore o uguale a 0!", Toast.LENGTH_SHORT).show(); errore = true; };
                if(!errore)
                    x.setText(String.valueOf(l.calcolaLogaritmo(a,b)));
            }
        }
    }
}
