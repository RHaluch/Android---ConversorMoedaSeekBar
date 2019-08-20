package com.example.moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class MainActivity extends AppCompatActivity {

    private TextView textValor, resultado, informacao, quantidade, tipoMoeda;
    private SeekBar seekValor;
    private CheckBox troca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValor = findViewById(R.id.textValor);
        resultado = findViewById(R.id.resultado);
        informacao = findViewById(R.id.informacao);
        quantidade = findViewById(R.id.quantidade);
        seekValor = findViewById(R.id.seekValor);
        troca = findViewById(R.id.troca);
        tipoMoeda = findViewById(R.id.tipoMoeda);

        troca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                DecimalFormat df = new DecimalFormat("#0.00");

                if (checked) {
                    informacao.setText("Conversor de moeda (Dolar -> Real)");
                    String saida = "R$ " + df.format(Float.parseFloat(quantidade.getText().toString()) / 4.04);
                    resultado.setText(saida);
                    textValor.setText("Valor em Dolar");
                    tipoMoeda.setText("Valor em Real");
                } else {

                    informacao.setText("Conversor de moeda (Real -> Dolar)");
                    String saida = "U$ " + df.format(Float.parseFloat(quantidade.getText().toString()) * 4.04);
                    resultado.setText(saida);
                    textValor.setText("Valor em Real");
                    tipoMoeda.setText("Valor em Dolar");
                }
            }
        });


        seekValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                quantidade.setText(String.valueOf(i));
                DecimalFormat df = new DecimalFormat("#0.00");

                if (troca.isChecked()) {
                    String saida = "R$ " + df.format(Float.parseFloat(quantidade.getText().toString()) / 4.04);
                    resultado.setText(saida);
                } else {
                    String saida = "U$ " + df.format(Float.parseFloat(quantidade.getText().toString()) * 4.04);
                    resultado.setText(saida);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
