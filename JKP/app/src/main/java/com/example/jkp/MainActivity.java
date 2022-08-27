package com.example.jkp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
// Nome: Júlia Téles Cruz       RA: 200558
// Nome: Victor Hugo Betoni     RA: 200154
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaJogo(View v){
        Intent tela = new Intent(this, PlayActivity.class);
        startActivity(tela);
    }
}