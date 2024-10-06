package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.teste.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola / 111048231311>
     */

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private EditText txtValorA;
    private EditText txtValorB;
    private EditText txtValorC;
    private TextView labelResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorA = findViewById(R.id.txtValorA);
        txtValorB = findViewById(R.id.txtValorB);
        txtValorC = findViewById(R.id.txtValorC);
        btnCalcular = findViewById(R.id.btnCalcular);
        labelResultado = findViewById(R.id.labelResultado);


        btnCalcular.setOnClickListener(op -> {
            String resultado = calc();
            labelResultado.setText(resultado);
        });
    }

    private String calc(){
        float a = Float.parseFloat(txtValorA.getText().toString());
        float b = Float.parseFloat(txtValorB.getText().toString());
        float c = Float.parseFloat(txtValorC.getText().toString());

        float delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            return "Delta: "+ delta +"\nA equação não possui raízes reais.";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Delta: "+ delta +"\nA equação possui uma raiz real: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Delta: "+ delta +"\nA equação possui duas raízes reais: x1 = " + x1 + ", x2 = " + x2;
        }

    }

}