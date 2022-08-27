package com.example.imparpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioPar, radioImpar;
    private ImageView imageVoce, imageMaquina, imageResultado;
    private TextView labelPartidas, labelVitorias, labelDerrotas;
    private RadioGroup radioGroup;

    private int contaPartidas, contaVitorias, contaDerrotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        radioPar = findViewById(R.id.radioPar);
        radioImpar = findViewById(R.id.radioImpar);
        imageVoce = findViewById(R.id.imageVoce);
        imageMaquina = findViewById(R.id.imageMaquina);
        imageResultado = findViewById(R.id.imageResultado);
        labelPartidas = findViewById(R.id.labelPartidas);
        labelVitorias = findViewById(R.id.labelVitorias);
        labelDerrotas = findViewById(R.id.labelDerrotas);
        radioGroup = findViewById(R.id.radioGroup);

        contaDerrotas = 0;
        contaVitorias = 0;
        contaPartidas = 0;
    }

    public void Escolher(View v){
        int escolhaCPU, escolhaJogador = 0;

        contaPartidas++;

        if (radioImpar.isChecked()){
            escolhaJogador = 1;
        } else if(radioPar.isChecked()) {
            escolhaJogador = 2;
        } else {
            Toast.makeText(this, "Escolha par ou ímpar!", Toast.LENGTH_SHORT).show();
        }

        if(escolhaJogador > 0) {
            Random rand = new Random();
            escolhaCPU = rand.nextInt(2) + 1;

            if (escolhaCPU == 1 && escolhaJogador == 2) {
                //1+2=3, ímpar
                contaDerrotas++;
                imageMaquina.setImageResource(R.drawable.impar);
                imageVoce.setImageResource(R.drawable.par);
                imageResultado.setImageResource(R.drawable.youlose);

            } else if(escolhaCPU == 2 && escolhaJogador == 2) {
                //2+2=4, par
                contaVitorias++;
                imageMaquina.setImageResource(R.drawable.par);
                imageVoce.setImageResource(R.drawable.par);
                imageResultado.setImageResource(R.drawable.youwin);
            }else if(escolhaCPU == 2 && escolhaJogador == 1) {
                //2+1=3, ímpar
                contaVitorias++;
                imageMaquina.setImageResource(R.drawable.par);
                imageVoce.setImageResource(R.drawable.impar);
                imageResultado.setImageResource(R.drawable.youwin);
            }else if(escolhaCPU == 1 && escolhaJogador == 1) {
                //1+1=2, par
                contaDerrotas++;
                imageMaquina.setImageResource(R.drawable.impar);
                imageVoce.setImageResource(R.drawable.impar);
                imageResultado.setImageResource(R.drawable.youlose);
            }
        }

        labelDerrotas.setText(MessageFormat.format("Derrotas: {0}", contaDerrotas));
        labelVitorias.setText(MessageFormat.format("Vitórias: {0}", contaVitorias));
        labelPartidas.setText(MessageFormat.format("Partidas: {0}", contaPartidas));
    }
}