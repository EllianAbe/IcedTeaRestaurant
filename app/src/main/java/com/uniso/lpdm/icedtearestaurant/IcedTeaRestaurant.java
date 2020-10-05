//Ellian Yemon Abe -  Ciência da Computação - 00098381

package com.uniso.lpdm.icedtearestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;

public class IcedTeaRestaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iced_tea_restaurant);
    }

    // função disparada no click do botão de confirmação do pedido - por enquanto muda o valor do text view para "Registrando pedido"
    public void onClickOrder(View view){
        TextView textArea01 = (TextView) findViewById(R.id.textArea01);

        textArea01.setText("Registrando pedido");
    }

    // função disparada no click do botão do total de horas - por enquanto muda o valor do text view para "Total de horas"
    public void onClickGetTotalHours(View view) {
        TextView textArea01 = (TextView) findViewById(R.id.textArea01);

        textArea01.setText("Total de horas");

        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    // função apenas chama a nova atividade do Assistant Messenger usando um intent explícito.
    public void onClickAssistantMessenger(View view) {
        Intent intent = new Intent(this, AssistantMessageActivity.class);

        startActivity(intent);
    }
}