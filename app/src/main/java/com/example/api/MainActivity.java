package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView relogio1 = findViewById(R.id.relogio1);
        ImageView relogio2 = findViewById(R.id.relogio2);
        ImageView relogio3 = findViewById(R.id.relogio3);
        ImageView relogio4 = findViewById(R.id.relogio4);
        ImageView relogio5 = findViewById(R.id.relogio5);
        ImageView relogio6 = findViewById(R.id.relogio6);

        relogio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio1";
                String valor = "17479";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
        relogio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio2";
                String valor = "17700";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
        relogio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio3";
                String valor = "19659";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
        relogio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio4";
                String valor = "20437";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
        relogio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio5";
                String valor = "28900";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
        relogio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, relogioActivity.class);
                String relogio = "relogio6";
                String valor = "29299";
                intent.putExtra("chave_relogio", relogio);
                intent.putExtra("chave_valor", valor);
                startActivity(intent);
            }
        });
    }
}