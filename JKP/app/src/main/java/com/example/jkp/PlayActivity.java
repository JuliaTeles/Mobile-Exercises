package com.example.jkp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private RadioButton rbPedra, rbPapel, rbTesoura;
    private ImageView ivCampo;
    private TextView tvPartidas, tvVitorias, tvEmpates, tvDerrotas;
    private RadioGroup rgEscolha;

    private int contaPartidas, contaVitorias, contaEmpates, contaDerrotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rbPedra = findViewById(R.id.rbPedra);
        rbPapel = findViewById(R.id.rbPapel);
        rbTesoura = findViewById(R.id.rbTesoura);
        ivCampo = findViewById(R.id.ivCampo);
        tvPartidas = findViewById(R.id.tvPartidas);
        tvVitorias = findViewById(R.id.tvVitorias);
        tvEmpates = findViewById(R.id.tvEmpates);
        tvDerrotas = findViewById(R.id.tvDerrotas);
        rgEscolha = findViewById(R.id.rgEscolha);

        contaDerrotas = 0;
        contaVitorias = 0;
        contaEmpates = 0;
        contaPartidas = 0;
    }

    public void Escolher(View  v){
        int escolhaCPU, escolhaJogador = 0;

        contaPartidas++;

        if (rbPedra.isChecked()){
            escolhaJogador = 1;
        } else if(rbPapel.isChecked()) {
            escolhaJogador = 2;
        } else if (rbTesoura.isChecked()) {
            escolhaJogador = 3;
        } else {
            Toast.makeText(this, "Escolha pedra, papel ou tesoura!", Toast.LENGTH_SHORT).show();
        }

        if(escolhaJogador > 0) {
            Random rand = new Random();
            escolhaCPU = rand.nextInt(3) + 1;

            if (escolhaCPU == 1 && escolhaJogador == 2) {
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.pedra_papel);
            } else if(escolhaCPU == 2 && escolhaJogador == 3) {
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.papel_tesoura);
            } else if (escolhaCPU == 3 && escolhaJogador == 1) {
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.tesoura_pedra);
            } else if(escolhaCPU == 1 && escolhaJogador == 1){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.pedra_pedra);
            } else if(escolhaCPU == 2 && escolhaJogador == 2){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.papel_papel);
            } else if(escolhaCPU == 3 && escolhaJogador == 3){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.tesoura_tesoura);
            } else if (escolhaJogador == 1 && escolhaCPU == 2) {
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.pedra_papel);
            } else if (escolhaJogador == 2 && escolhaCPU == 3) {
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.papel_tesoura);
            } else if (escolhaJogador == 3 && escolhaCPU == 1) {
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.pedra_papel);
            }
        }
    }
}