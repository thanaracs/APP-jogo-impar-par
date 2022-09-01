package com.thainaracarvalho.exemplosdesplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide(); //o tema sera apenas para essa atividade

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //o que quero que seja execultado na segunda tread
                //propertiesbar para dar a sensação de tela carregando
                Intent it = new Intent(getActivity(), MainActivity.class); //Objeto de mensagem
                startActivity(it);
            }
        }, 3000);//delay de atraso

    }//onCreate

    public Context getActivity(){
        return this;
    }

}//closs