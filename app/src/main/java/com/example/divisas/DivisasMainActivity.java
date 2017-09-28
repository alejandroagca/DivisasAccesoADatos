package com.example.divisas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class DivisasMainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton rbtDaE;
    Button convertir;
    EditText etDolares;
    EditText etEuros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisas_main);
        rbtDaE = (RadioButton) findViewById(R.id.radioButtonDaE);
        etDolares = (EditText) findViewById(R.id.editTextDolares);
        etEuros = (EditText) findViewById(R.id.editTextEuros);
        convertir = (Button) findViewById(R.id.buttonConvertir);
        convertir.setOnClickListener(this);
    }

    public String Convertir(String cantidad)
    {
        double calculo;
        double cambioAEuros = 0.846345902;
        double cambioADolares = 1.18155;
        if (rbtDaE.isChecked())
        {
            calculo = (Double.parseDouble(cantidad)*cambioAEuros);
        }
        else
        {
            calculo =(Double.parseDouble(cantidad)*cambioADolares);
        }

        return String.format("%.2f",calculo);
    }

    public void onClick(View view)
    {
        if (view == convertir)
        {
            if (rbtDaE.isChecked())
            {
                etEuros.setText(Convertir(etDolares.getText().toString()));
            }
            else
            {
                etDolares.setText(Convertir(etEuros.getText().toString()));
            }
        }

    }
}
