package com.four436.controllerbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ChooseControlActivity extends AppCompatActivity {
    MaterialButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_control);
        backBtn = findViewById(R.id.bkBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(ChooseControlActivity.this, MainActivity.class);
                startActivity(inten);
            }
        });
    }

    public void mouseChose(View view){
        Intent intent = new Intent(ChooseControlActivity.this, MouseActivity.class);
        startActivity(intent);
    }

    public void keyboardChose(View view){
        Intent intent = new Intent(ChooseControlActivity.this, KeyboardActivity.class);
        startActivity(intent);
    }

    public void textChose(View view){
        Intent intent = new Intent(ChooseControlActivity.this, TextActivity.class);
        startActivity(intent);
    }

}