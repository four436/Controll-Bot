package com.four436.controllerbot;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private EditText ipAddr;
    private EditText port;
    private String ip;
    private int portNum;
    public static final Socket BOT_SOCKET = new Socket();
    public Socket bot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipAddr = findViewById(R.id.ipAddr);
        InputFilter[] filtersIp = new InputFilter[1];
        filtersIp[0] = new InputFilter.LengthFilter(15);
        ipAddr.setFilters(filtersIp);
        port = findViewById(R.id.inPort);
        InputFilter[] filtersPort = new InputFilter[1];
        filtersPort[0] = new InputFilter.LengthFilter(5);
        port.setFilters(filtersPort);
    }

    public void clicked(View view){
        if(ipAddr.getText().toString().isEmpty() || port.getText().toString().isEmpty()){
            Toast.makeText(this, "Put an ip address and a port", Toast.LENGTH_SHORT).show();
            return;
        }
        ip = ipAddr.getText().toString();
        portNum = Integer.parseInt(port.getText().toString());
        if(portNum <0 || portNum >65535){
            Toast.makeText(this, "Put a value between 0 and 65535", Toast.LENGTH_SHORT).show();
            port.setText("");
            return;
        }
        Toast.makeText(this, "Trying to connect...", Toast.LENGTH_SHORT).show();
        connect();
    }

    public void AllrdCnct(View view){
        SocketManager.IsConnected(new SocketManager.ConnectionCallback() {
            @Override
            public void onConnectionResult(boolean success) {
                if(success) {
                    Intent intent = new Intent(MainActivity.this, ChooseControlActivity.class);
                    startActivity(intent);
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Must connect first", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }

    public void connect(){
        SocketManager.Connect(ip, portNum, new SocketManager.ConnectionCallback() {
            @Override
            public void onConnectionResult(boolean success) {
                if(success) {
                    Intent intent = new Intent(MainActivity.this, ChooseControlActivity.class);
                    startActivity(intent);
                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "       Failed to connect\n\rIncorrect Ip address or port", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        SocketManager.StartCommunication();
        
    }
}