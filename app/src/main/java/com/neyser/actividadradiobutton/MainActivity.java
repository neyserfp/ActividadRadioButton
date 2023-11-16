package com.neyser.actividadradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText t1, t2;
    private RadioButton r1, r2, r3, r4;
    private Button b1;
    private TextView lResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        b1 = findViewById(R.id.b1);
        lResultado = findViewById(R.id.lResultado);

        int valor1 = Integer.valueOf(t1.getText().toString());
        int valor2 = Integer.valueOf(t2.getText().toString());
        int operacion = 0;
        String resultado = "";

        if (r1.isChecked()){
            operacion = valor1+valor2;
            resultado = String.valueOf(operacion);
        } else if (r2.isChecked()) {
            operacion = valor1*valor2;
            resultado = String.valueOf(operacion);
        } else if (r3.isChecked()) {
            try {
                operacion = valor1/valor2;
                resultado = String.valueOf(operacion);
            } catch (Exception e){
                resultado = "El valor: " + valor2 + " no es válido";
                t2.setText("");
            }
        } else if (r4.isChecked()) {
            operacion = valor1-valor2;
            resultado = String.valueOf(operacion);
        } else {
            Toast.makeText(this,"Debe elegir alguna opción válida", Toast.LENGTH_LONG).show();
        }

        lResultado.setText(resultado);

    }
}