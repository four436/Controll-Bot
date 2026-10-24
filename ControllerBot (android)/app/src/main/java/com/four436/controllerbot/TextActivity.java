package com.four436.controllerbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {

    private int lastTextLength = 0;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        textField = findViewById(R.id.text);
    }

    public void backBtn(View view){
        Intent intent = new Intent(TextActivity.this, ChooseControlActivity.class);
        startActivity(intent);

    }

    public void Send(View view) {
        String txt = textField.getText().toString();
        lastTextLength = txt.length();
        TextCommunication.sendText(txt);
        textField.setText("");
    }

    public void deleteLastText(View view) {
        TextCommunication.sendDeleteLastText(lastTextLength);
    }

    public void backspace(View view) {
        TextCommunication.sendBackspace();
    }

    public void enter(View view) {
        TextCommunication.sendEnter();
    }

}