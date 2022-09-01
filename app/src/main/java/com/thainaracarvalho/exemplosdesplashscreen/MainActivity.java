package com.thainaracarvalho.exemplosdesplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButtonPar, radioButtonImpar;
    private Button buttonJogar;
    private Integer resposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonImpar = findViewById(R.id.radioButtonImpar);
        radioButtonPar = findViewById(R.id.radioButtonPar);
        buttonJogar = findViewById(R.id.buttonJogar);
        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gerarNumeros(); //para poder jogar mais de 1 vez
                resposta=0;
            }
        });

    }//onCreate

    public void escolher (View view){
        RadioButton rb = (RadioButton) view;
        boolean selecionado = rb.isChecked();
        if (view.getId() == R.id.radioButtonImpar) {
            if(selecionado){
                Toast.makeText(getApplicationContext(), "IMPAR",
                        Toast.LENGTH_SHORT).show();
                resposta = 1;
            }
        }
        if (view.getId() == R.id.radioButtonPar) {
            if(selecionado){
                Toast.makeText(getApplicationContext(), "PAR",
                        Toast.LENGTH_SHORT).show();
                resposta = 2;
            }
        }
    }//escolher

    private void gerarNumeros(){
        Random r = new Random();
        int numJogador = r.nextInt(11);
        int numComputador = r.nextInt(11);
        int soma = numJogador + numComputador;
        if((soma%2==0 && resposta==2)||(soma%2!=0 && resposta==1)){
            Toast.makeText(getApplicationContext(),
                    "Jogador ganhou "+ soma,
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),
                    "Android ganhou "+soma,
                    Toast.LENGTH_SHORT).show();
        }
    }

}