package com.four436.controllerbot;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TextCommunication {

    private static Socket clientSocket;
    private static BufferedWriter writer;
    private static final int PORT = 11112;

    public interface ConnectionCallback {
        void onConnectionResult(boolean success);
    }

    public static void connect(String hostName, final ConnectionCallback callback) {
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

    public static void sendText(String text) {
        new Thread(() -> {
            try {
                writer.write(0); // Operation code for sending text
                writer.flush();
                writer.write(text + "\n");
                writer.flush();
            } catch (Exception e) {
                System.err.println("Error sending text: " + e.getMessage());
            }
        }).start();
    }

    public static void sendDeleteLastText(int textLength) {
        new Thread(() -> {
            try {
                writer.write(1); // Operation code for deleting text
                writer.flush();
                writer.write(textLength); // Send text length
                writer.flush();
            } catch (Exception e) {
                System.err.println("Error sending delete command: " + e.getMessage());
            }
        }).start();
    }

    public static void sendBackspace() {
        new Thread(() -> {
            try {
                writer.write(2); // Operation code for backspace
                writer.flush();
            } catch (Exception e) {
                System.err.println("Error sending backspace: " + e.getMessage());
            }
        }).start();
    }

    public static void sendEnter() {
        new Thread(() -> {
            try {
                writer.write(3); // Operation code for enter
                writer.flush();
            } catch (Exception e) {
                System.err.println("Error sending enter: " + e.getMessage());
            }
        }).start();
    }

    public static void disconnect() {
        try {
            if (writer != null) writer.close();
            if (clientSocket != null) clientSocket.close();
            System.out.println("Disconnected from server.");
        } catch (Exception e) {
            System.err.println("Error disconnecting: " + e.getMessage());
        }
    }
}