package com.four436.controllerbot;

import android.content.Intent;
import android.widget.Toast;

import java.net.Socket;

public class SocketManager {
    private static Socket socket;
    private static String IPAddr;
    private static int port;
    public static Socket getSocket(){

        return socket;
    }

    public static void IsConnected(final ConnectionCallback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(socket != null) {
                    callback.onConnectionResult(socket.isConnected());
                }else{
                    callback.onConnectionResult(false);
                }
            }
        }).start();
    }

    public static void Connect(String ip, int Port, final ConnectionCallback callback) {
        IPAddr = ip;
        port = Port;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(IPAddr, port);
                    // Connection successful
                    callback.onConnectionResult(true);
                } catch (Exception e) {
                    // Connection failed
                    callback.onConnectionResult(false);
                }
            }
        }).start();
    }

    public static void StartCommunication(){
        MouseCommunication.ConnectMouseCommunication(IPAddr,new MouseCommunication.ConnectionCallback(){
            @Override
            public void onConnectionResult(boolean success) {

            }
        });
        TextCommunication.connect(IPAddr,new TextCommunication.ConnectionCallback(){
            @Override
            public void onConnectionResult(boolean success) {

            }
        });
        KeyboardCommunication.connect(IPAddr,new TextCommunication.ConnectionCallback(){
            @Override
            public void onConnectionResult(boolean success) {

            }
        });
    }

    public interface ConnectionCallback {
        void onConnectionResult(boolean success);
    }

}
