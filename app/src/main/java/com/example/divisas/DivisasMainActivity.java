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
        etDolares = (EditText) findViewById(R.id.editTextDolares);
        etEuros = (EditText) findViewById(R.id.editTextEuros);
        convertir = (Button) findViewById(R.id.buttonConvertir);
        convertir.setOnClickListener(this);
    }

    public String Convertir()
    {
        double calculo;
        double cambioAEuros = 0.846345902;
        double cambioADolares = 1.18155;
        rbtDaE = (RadioButton) findViewById(R.id.radioButtonDaE);
        if (rbtDaE.isChecked())
        {
            calculo = (Double.parseDouble(etDolares.getText().toString())*cambioAEuros);
        }
        else
        {
            calculo =(Double.parseDouble(etEuros.getText().toString())*cambioADolares);
        }

        return String.format("%.2f",calculo);
    }

    @Override
    public void onClick(View view)
    {
        if (view == convertir)
        {
            if (rbtDaE.isChecked())
            {
                etEuros.setText(Convertir());
            }
            else
            {
                etDolares.setText(Convertir());
            }
        }

    }
}
