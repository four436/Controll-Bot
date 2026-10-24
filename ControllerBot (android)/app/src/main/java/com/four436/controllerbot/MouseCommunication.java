package com.four436.controllerbot;

import java.net.Socket;

public class MouseCommunication {
    private static Socket comms;
    private static int port=11111;
    public static void ConnectMouseCommunication(String hostName, final ConnectionCallback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    comms = new Socket(hostName, port);
                    callback.onConnectionResult(true);
                } catch (Exception e) {
                    callback.onConnectionResult(false);
                }
            }
        }).start();
    }

    public static void SendMouseMovement(int x, int y){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    comms.getOutputStream().write(0);
                    comms.getOutputStream().flush();
                    comms.getOutputStream().write(x);
                    comms.getOutputStream().flush();
                    comms.getOutputStream().write(y);
                    comms.getOutputStream().flush();
                } catch (Exception e) {
                    //TODO complete this catch{}, optionaly!
                }
            }
        }).start();
    }

    public static void SendNegativeMouseMovement(int x, int y){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    comms.getOutputStream().write(5);
                    comms.getOutputStream().flush();
                    comms.getOutputStream().write(x);
                    comms.getOutputStream().flush();
                    comms.getOutputStream().write(y);
                    comms.getOutputStream().flush();
                } catch (Exception e) {
                    //TODO complete this catch{}, optionaly!
                }
            }
        }).start();
    }

    public static void SendMouseClick(int button){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    comms.getOutputStream().write(1);
                    comms.getOutputStream().flush();
                }catch (Exception e){
                    //TODO complete this catch{}, optionaly!
                }
                if(button == 1){
                    try {
                        comms.getOutputStream().write(1);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }else{
                    try {
                        comms.getOutputStream().write(0);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }
            }
        }).start();
    }

    public static void SendMouseHold(int button){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    comms.getOutputStream().write(2);
                    comms.getOutputStream().flush();
                }catch (Exception e){
                    //TODO complete this catch{}, optionaly!
                }
                if(button == 1){
                    try {
                        comms.getOutputStream().write(1);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }else{
                    try {
                        comms.getOutputStream().write(0);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }
            }
        }).start();
    }

    public static void SendMouseReleaseHold(int button){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    comms.getOutputStream().write(3);
                    comms.getOutputStream().flush();
                }catch (Exception e) {
                    //TODO complete this catch{}, optionaly!
                }
                if(button == 1){
                    try {
                        comms.getOutputStream().write(1);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }else{
                    try {
                        comms.getOutputStream().write(0);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }
            }
        }).start();
    }

    public static void SendMouseScroll(int direction){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    comms.getOutputStream().write(4);
                    comms.getOutputStream().flush();
                }catch (Exception e) {
                    //TODO complete this catch{}, optionaly!
                }
                if(direction == 1){
                    try {
                        comms.getOutputStream().write(1);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }else{
                    try {
                        comms.getOutputStream().write(0);
                        comms.getOutputStream().flush();
                    } catch (Exception e) {
                        //TODO complete this catch{}, optionaly!
                    }
                }
            }
        }).start();
    }


    public interface ConnectionCallback {
        void onConnectionResult(boolean success);
    }

}
