package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double numerouno;
    String opperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n0 = findViewById(R.id.n0);
        Button n1 = findViewById(R.id.n1);
        Button n2 = findViewById(R.id.n2);
        Button n3 = findViewById(R.id.n3);
        Button n4 = findViewById(R.id.n4);
        Button n5 = findViewById(R.id.n5);
        Button n6 = findViewById(R.id.n6);
        Button n7 = findViewById(R.id.n7);
        Button n8 = findViewById(R.id.n8);
        Button n9 = findViewById(R.id.n9);

        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button div = findViewById(R.id.div);
        Button xxxtentacion = findViewById(R.id.xxxtentacion);
        Button mas = findViewById(R.id.mas);
        Button menos = findViewById(R.id.menos);
        Button punto = findViewById(R.id.punto);
        Button igual = findViewById(R.id.igual);
        Button borrar = findViewById(R.id.borrar);

        TextView pantalla = findViewById(R.id.pantalla);

        borrar.setOnClickListener(view -> {
            numerouno = 0;
            pantalla.setText("0");
        });

        off.setOnClickListener(view -> pantalla.setVisibility(view.GONE));
        on.setOnClickListener(view -> {
                pantalla.setVisibility(view.VISIBLE);
                pantalla.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(n0);
        nums.add(n1);
        nums.add(n2);
        nums.add(n3);
        nums.add(n4);
        nums.add(n5);
        nums.add(n6);
        nums.add(n7);
        nums.add(n8);
        nums.add(n9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!pantalla.getText().toString().equals("0")) {
                    pantalla.setText(pantalla.getText().toString() + b.getText().toString());
                } else {
                    pantalla.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> oppers = new ArrayList<>();
        oppers.add(mas);
        oppers.add(menos);
        oppers.add(xxxtentacion);
        oppers.add(div);

        for (Button b : oppers){
            b.setOnClickListener(view -> {
                numerouno = Double.parseDouble(pantalla.getText().toString());
                opperacion = b.getText().toString();
                pantalla.setText("0");
            });
        }
        borrar.setOnClickListener(view -> {
            String num = pantalla.getText().toString();
            if (num.length()>1) {
                pantalla.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")) {
                pantalla.setText("0");
            }
        });

        punto.setOnClickListener(view -> {
            if (!pantalla.getText().toString().contains(".")) {
                pantalla.setText(pantalla.getText().toString() + ".");
            }
        });

        igual.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(pantalla.getText().toString());
            double resultado;
            switch (opperacion) {
                case "/":
                    resultado = numerouno/secondNum;
                    break;
                case "x":
                    resultado = numerouno * secondNum;
                    break;
                case "+":
                    resultado = numerouno + secondNum;
                    break;
                case "-":
                    resultado = numerouno - secondNum;
                    break;
                default:
                    resultado = numerouno + secondNum;
            }
            pantalla.setText(String.valueOf(resultado));
            numerouno = resultado;
        });
    }
}