package com.uniso.lpdm.icedtearestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AssistantMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant_message);
    }

    // atividade responsável por criar enviar uma intent implícita.
    public void onClickSendAssistantMessage(View view) {
        // recupera o editText e a mensagem contida no campo
        EditText editText = (EditText) findViewById(R.id.assistantMessage);
        String assistantMessageText = editText.getText().toString();

        // cria a intent (implícita).
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, assistantMessageText);

        // envia para o Android.
        startActivity(intent);
    }
}