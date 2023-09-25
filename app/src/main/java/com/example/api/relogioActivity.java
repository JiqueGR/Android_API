package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class relogioActivity extends AppCompatActivity {
    TextView txtValor;
    Button btnDolar;
    Button btnEuro;
    Button btnLibra;
    String moedaSigla;
    String moeda;
    ImageView imagem;
    String relogio;
    String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relogio);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("chave_relogio")) {
                 relogio = intent.getStringExtra("chave_relogio");
            }

            if (intent.hasExtra("chave_valor")) {
                 valor = intent.getStringExtra("chave_valor");
            }
        }

        txtValor = findViewById(R.id.txtValor);
        btnDolar = findViewById(R.id.btnDolar);
        btnEuro = findViewById(R.id.btnEuro);
        btnLibra = findViewById(R.id.btnLibra);

        imagem = findViewById(R.id.relogioView);
        int resourceId = getResources().getIdentifier(relogio, "drawable", getPackageName());
        imagem.setImageResource(resourceId);

        txtValor.setText("R$" + valor);
        btnDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moedaSigla = "USD";
                String url = "https://economia.awesomeapi.com.br/last/USD-BRL";
                moeda = "$";
                new relogioActivity.FetchJsonTask().execute(url);
            }
        });

        btnLibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moedaSigla = "GBP";
                String url = "https://economia.awesomeapi.com.br/last/GBP-BRL";
                moeda = "£";
                new relogioActivity.FetchJsonTask().execute(url);
            }
        });

        btnEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moedaSigla = "EUR";
                String url = "https://economia.awesomeapi.com.br/last/EUR-BRL";
                moeda = "€";
                new relogioActivity.FetchJsonTask().execute(url);
            }
        });
    }

    private class FetchJsonTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonObject = new JSONObject(response.toString());
                String bid = jsonObject.getJSONObject(moedaSigla + "BRL").getString("bid");

                return bid;

            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(String json) {
            if (json != null) {
                if(moeda == "$"){
                    float valorFloat = Float.parseFloat(valor);
                    valorFloat = valorFloat / Float.parseFloat(json);
                    DecimalFormat df = new DecimalFormat("0.00");
                    String numeroFormatado = df.format(valorFloat);
                    txtValor.setText(moeda + numeroFormatado);
                }
                else if(moeda == "£"){
                    float valorFloat = Float.parseFloat(valor);
                    valorFloat = valorFloat / Float.parseFloat(json);
                    DecimalFormat df = new DecimalFormat("0.00");
                    String numeroFormatado = df.format(valorFloat);
                    txtValor.setText(moeda + numeroFormatado);
                }
                else if(moeda == "€"){
                    float valorFloat = Float.parseFloat(valor);
                    valorFloat = valorFloat / Float.parseFloat(json);
                    DecimalFormat df = new DecimalFormat("0.00");
                    String numeroFormatado = df.format(valorFloat);
                    txtValor.setText(moeda + numeroFormatado);
                }
            }
        }
    }
}