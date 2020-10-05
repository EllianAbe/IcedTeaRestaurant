package com.uniso.lpdm.icedtearestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    private boolean executando = false, estavaExecutando = false;
    private int segundos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        if(savedInstanceState != null) {
            segundos = savedInstanceState.getInt("segundos");
            executando = savedInstanceState.getBoolean("executando");
        }

        executarTemporizador();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("segundos", segundos);
        savedInstanceState.putBoolean("executando", executando);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        estavaExecutando = executando;

        super.onStop();
    }

    public void onClickIniciar(View view) {
        executando = true;
    }

    public void onClickParar(View view) {
        executando = false;
    }

    public void onClickEncerrar(View view) {
        executando = false;
        segundos = 0;
    }

    public void onClickVoltar(View view) {
        Intent intent = new Intent(this, IcedTeaRestaurant.class);

        startActivity(intent);
    }

    private void executarTemporizador() {
        final TextView textView = (TextView) findViewById(R.id.txtTempo);

        final Handler handler = new Handler();

        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        int horas = segundos/3600;
                        int minutos = (segundos%3600)/60;
                        int segundos_interno = segundos % 60;

                        String time = String.format(Locale.getDefault(),
                                "%d:%02d:%02d", horas, minutos, segundos_interno);

                        textView.setText(time);

                        if(executando) {
                            ++segundos;
                        }

                        handler.postDelayed(this, 1000);
                    }
                }
        );
    }
}