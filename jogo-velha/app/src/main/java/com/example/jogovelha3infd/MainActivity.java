package com.example.jogovelha3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnReset;
    private String player;
    private int[] playadas = {-1, -2, -3, -4, -5, -6, -7, -8, -9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnReset = findViewById(R.id.btnReset);

        player = "X";
    }

    public void play(View v) {
        Button clicked = findViewById(v.getId());
        clicked.setText(player);
        clicked.setEnabled(false);
        clicked.setTextSize(70);

        int numeroJogador = (player == "X" ? 1 : 0);

        if(v.getId() == R.id.btn0) playadas[0] = numeroJogador;
        if(v.getId() == R.id.btn1) playadas[1] = numeroJogador;
        if(v.getId() == R.id.btn2) playadas[2] = numeroJogador;
        if(v.getId() == R.id.btn3) playadas[3] = numeroJogador;
        if(v.getId() == R.id.btn4) playadas[4] = numeroJogador;
        if(v.getId() == R.id.btn5) playadas[5] = numeroJogador;
        if(v.getId() == R.id.btn6) playadas[6] = numeroJogador;
        if(v.getId() == R.id.btn7) playadas[7] = numeroJogador;
        if(v.getId() == R.id.btn8) playadas[8] = numeroJogador;

        if ((playadas[0] == playadas[1]) && (playadas[1] == playadas[2])) {
            //012
            ganhou();
        } else if ((playadas[3] == playadas[4]) && (playadas[4] == playadas[5])) {
            //345
            ganhou();
        } else if ((playadas[6] == playadas[7]) && (playadas[7] == playadas[8])) {
            //678
            ganhou();
        } else if ((playadas[0] == playadas[3]) && (playadas[3] == playadas[6])) {
            //036
            ganhou();
        } else if ((playadas[1] == playadas[4]) && (playadas[4] == playadas[7])) {
            //147
            ganhou();
        } else if ((playadas[2] == playadas[5]) && (playadas[5] == playadas[8])) {
            //258
            ganhou();
        } else if ((playadas[0] == playadas[4]) && (playadas[4] == playadas[8])) {
            //048
            ganhou();
        } else if ((playadas[2] == playadas[4]) && (playadas[4] == playadas[6])) {
            //246
            ganhou();
        }

        if (player.equalsIgnoreCase("X")) {
            player = "O";
        } else {
            player = "X";
        }

    }

    public void ganhou() {
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        Toast.makeText(this, "O jogador " + player + " ganhou" , Toast.LENGTH_SHORT).show();
    }

    public void reset(View v) {
        btn0.setTextSize(14);
        btn1.setTextSize(14);
        btn2.setTextSize(14);
        btn3.setTextSize(14);
        btn4.setTextSize(14);
        btn5.setTextSize(14);
        btn6.setTextSize(14);
        btn7.setTextSize(14);
        btn8.setTextSize(14);

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);

        btn0.setText("Jogar!");
        btn1.setText("Jogar!");
        btn2.setText("Jogar!");
        btn3.setText("Jogar!");
        btn4.setText("Jogar!");
        btn5.setText("Jogar!");
        btn6.setText("Jogar!");
        btn7.setText("Jogar!");
        btn8.setText("Jogar!");

        player = "X";
        playadas = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};
    }
}