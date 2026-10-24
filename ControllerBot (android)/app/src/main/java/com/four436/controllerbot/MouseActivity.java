package com.four436.controllerbot;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

public class MouseActivity extends AppCompatActivity {

    private MaterialSwitch sw;
     EditText speedinp;
    private int speed=1;
    private boolean hold=false;
    private boolean holdedlmb=false;
    private boolean holdedrmb=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);
        speedinp = findViewById(R.id.speedNr);
        sw = findViewById(R.id.holdSw);

    }

    public void backBtn(View view){
        Intent intent = new Intent(MouseActivity.this, ChooseControlActivity.class);
        startActivity(intent);
    }

    public void speedUp(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed>200){
            speed=200;
            speedinp.setText(String.valueOf(speed));
        }
        if(speed<200) {
            speed++;
            speedinp.setText(String.valueOf(speed));
        }
    }

    public void speedDown(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed<1){
            speed=1;
            speedinp.setText(String.valueOf(speed));
        }
        if(speed>1) {
            speed--;
            speedinp.setText(String.valueOf(speed));
        }
    }

    public void upBtn(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed>200){
            speed=200;
            speedinp.setText(String.valueOf(speed));
        }else if(speed<1){
            speed=1;
            speedinp.setText(String.valueOf(speed));
        }
        MouseCommunication.SendMouseMovement(0, speed);
    }

    public void downBtn(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed>200){
            speed=200;
            speedinp.setText(String.valueOf(speed));
        }else if(speed<1){
            speed=1;
            speedinp.setText(String.valueOf(speed));
        }
        MouseCommunication.SendNegativeMouseMovement(0,speed);
    }

    public void leftBtn(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed>200){
            speed=200;
            speedinp.setText(String.valueOf(speed));
        }else if(speed<1){
            speed=1;
            speedinp.setText(String.valueOf(speed));
        }
        MouseCommunication.SendNegativeMouseMovement(speed,0);
    }

    public void rightBtn(View view){
        speed = Integer.parseInt(speedinp.getText().toString());
        if(speed>200){
            speed=200;
            speedinp.setText(String.valueOf(speed));
        }else if(speed<1){
            speed=1;
            speedinp.setText(String.valueOf(speed));
        }
        MouseCommunication.SendMouseMovement(speed,0);
    }

    public void centerBtn(View view){

    }

    public void lmbBtn(View view){
        hold=sw.isChecked();
        if(hold){
            if(holdedlmb==false) {
                MouseCommunication.SendMouseHold(1);
                holdedlmb=true;
            }else{
                MouseCommunication.SendMouseReleaseHold(1);
                holdedlmb=false;
            }
        }else{
            holdedlmb=false;
            holdedrmb=false;
            MouseCommunication.SendMouseClick(1);
        }
    }

    public void rmbBtn(View view){
        hold=sw.isChecked();
        if(hold){
            if(holdedrmb==false) {
                MouseCommunication.SendMouseHold(0);
                holdedrmb=true;
            }else{
                MouseCommunication.SendMouseReleaseHold(0);
                holdedrmb=false;
            }
        }else{
            holdedrmb=false;
            holdedlmb=false;
            MouseCommunication.SendMouseClick(0);
        }
    }

    public void scrollUpBtn(View view){
        MouseCommunication.SendMouseScroll(1);
    }

    public void scrollDownBtn(View view){
        MouseCommunication.SendMouseScroll(0);
    }


    public void swState(View view){
        if(sw.isChecked()){
            Drawable ic= getDrawable(R.drawable.ic_right);
            sw.setThumbIconDrawable(ic);
        }else{
            Drawable ic= getDrawable(R.drawable.ic_left);
            sw.setThumbIconDrawable(ic);
        }
    }


}