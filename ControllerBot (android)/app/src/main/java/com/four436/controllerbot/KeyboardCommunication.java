package com.four436.controllerbot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class KeyboardCommunication {

    private static Socket clientSocket;
    private static BufferedWriter writer;
    private static final int PORT = 11113;

    public interface ConnectionCallback {
        void onConnectionResult(boolean success);
    }

    public static void connect(String hostName, final TextCommunication.ConnectionCallback callback) {
        new Thread(() -> {
            try {
                clientSocket = new Socket(hostName, PORT);
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                callback.onConnectionResult(true);
            } catch (Exception e) {
                System.err.println("Connection error: " + e.getMessage());
                callback.onConnectionResult(false);
            }
        }).start();
    }

    public static void escBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(0);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void tabBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(1);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void capsLockBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(2);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void shiftBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(3);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void ctrlBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(4);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void winBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(5);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void altBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(6);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void spaceBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(7);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void altGrBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(8);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void backspaceBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(9);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void enterBtn(boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(10);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void clickEscBtn(){
        new Thread(() -> {
            try {
                writer.write(11);
                writer.flush();
            } catch (Exception e) {
            }
        }).start();
    }

    public static void clickTabBtn(){
        new Thread(() -> {
            try {
                writer.write(12);
                writer.flush();
            } catch (Exception e) {
            }
        }).start();
    }

    public static void clickCapsLockBtn(){
        new Thread(() -> {
            try {
                writer.write(13);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickShiftBtn() {
        new Thread(() -> {
            try {
                writer.write(14);
                writer.flush();
            } catch (Exception e) {

            }
        }).start();
    }

    public static void clickCtrlBtn() {
        new Thread(() -> {
            try {
                writer.write(15);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickWinBtn() {
        new Thread(() -> {
            try {
                writer.write(16);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickAltBtn() {
        new Thread(() -> {
            try {
                writer.write(17);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickSpaceBtn() {
        new Thread(() -> {
            try {
                writer.write(18);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickAltGrBtn() {
        new Thread(() -> {
            try {
                writer.write(19);
                writer.flush();
            } catch (Exception e) {

            }
        }).start();
    }

    public static void clickBackspaceBtn() {
        new Thread(() -> {
            try {
                writer.write(20);
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }

    public static void clickEnterBtn() {
        new Thread(() -> {
            try {
                writer.write(21);
                writer.flush();
            } catch (Exception e) {
            }
        }).start();
    }

    public static void FuncBtn(int key, boolean pressed){
        new Thread(() -> {
            try {
                writer.write(22);
                writer.flush();
                writer.write(key);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {

            }
        }).start();
    }

    public static void LetterAndNumberBtn(char key, boolean pressed){
        new Thread(() -> {
            try {
                writer.write(23);
                writer.flush();
                writer.write(key+"\n");
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {

            }
        }).start();
    }

    public static void symbolKeyBtn(char key, boolean pressed){
        new Thread(() -> {
            try {
                writer.write(24);
                writer.flush();
                writer.write(key+"\n");
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (Exception e) {

            }
        }).start();
    }

    public static void clickFuncBtn(int key){
        new Thread(() -> {
            try {
                writer.write(25);
                writer.flush();
                writer.write(key);
                writer.flush();
            } catch (Exception e) {
            }
        }).start();
    }

    public static void clickLetterAndNumberBtn(char key){
        new Thread(() -> {
            try {
                writer.write(26);
                writer.flush();
                writer.write(key + "\n");
                writer.flush();
            } catch (Exception e) {
            }
        }).start();
    }

    public static void clickSymbolKeyBtn(char key){
        new Thread(() -> {
            try {
                writer.write(27);
                writer.flush();
                writer.write(key + "\n");
                writer.flush();
                } catch (Exception e) {
            }
        }).start();
    }
    public static void clickArrowBtn(int key) {
        new Thread(() -> {
            try {
                writer.write(28);
                writer.flush();
                writer.write(key);
                writer.flush();
            } catch (IOException e) {
                //TODO Handle the exception
            }
        }).start();
    }
    public static void pressArrowBtn(int key, boolean pressed) {
        new Thread(() -> {
            try {
                writer.write(29);
                writer.flush();
                writer.write(key);
                writer.flush();
                if(pressed){
                    writer.write(1);
                    writer.flush();
                }else{
                    writer.write(0);
                    writer.flush();
                }
            } catch (IOException e) {
                //TODO Handle the exception
            }
        }).start();
    }
}
