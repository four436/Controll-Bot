import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TextCommunication extends Thread {

    private Robot bot;
    private Socket clientSocket;
    private BufferedReader reader;

    public TextCommunication( Socket sk) {
        try {
            clientSocket = sk;
            System.out.println("Client connected.");
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            bot = new Robot();
        } catch (Exception e) {
            System.err.println("Error initializing server: " + e.getMessage());
            System.exit(1);
        }
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int choice = reader.read();
                if (choice == -1) break;
                switch (choice) {
                    case 0:
                        String text = reader.readLine();
                        if (text != null) {
                            System.out.println("Received text: " + text);
                            printText(text);
                        }
                        break;
                    case 1:
                        int length = reader.read();
                        System.out.println("Deleting last " + length + " characters.");
                        deleteLastText(length);
                        break;
                    case 2:
                        System.out.println("Backspace received.");
                        backSpace();
                        break;
                    case 3:
                        System.out.println("Enter received.");
                        enter();
                        break;
                    default:
                        System.out.println("Unknown command received: " + choice);
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error in communication: " + e.getMessage());
        } finally {
            closeConnections();
        }
    }

    private void printText(String text) {
        for (char c : text.toCharArray()) {
            int key = KeyEvent.getExtendedKeyCodeForChar(c);
            if (key != KeyEvent.VK_UNDEFINED) {
                if (Character.isUpperCase(c)) {
                    try {
                        bot.keyPress(KeyEvent.VK_SHIFT);
                        bot.keyPress(key);
                        bot.keyRelease(key);
                        bot.keyRelease(KeyEvent.VK_SHIFT);
                    } catch (Exception e) {
                        bot.keyPress(KeyEvent.VK_SHIFT);
                        bot.keyPress(KeyEvent.VK_7);
                        bot.keyRelease(KeyEvent.VK_7);
                        bot.keyRelease(KeyEvent.VK_SHIFT);
                    }
                } else if (isShiftRequired(c)) {
                    pressKeyWithShiftForSpecialChars(c);
                } else {
                    try {
                        bot.keyPress(key);
                        bot.keyRelease(key);
                    } catch (Exception e) {
                        bot.keyPress(KeyEvent.VK_SHIFT);
                        bot.keyPress(KeyEvent.VK_7);
                        bot.keyRelease(KeyEvent.VK_7);
                        bot.keyRelease(KeyEvent.VK_SHIFT);
                    }
                }
            }
        }
    }

    private void deleteLastText(int length) {
        for (int i = 0; i < length; i++) {
            bot.keyPress(KeyEvent.VK_BACK_SPACE);
            bot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }

    private void backSpace() {
        bot.keyPress(KeyEvent.VK_BACK_SPACE);
        bot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    private void enter() {
        bot.keyPress(KeyEvent.VK_ENTER);
        bot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void closeConnections() {
        try {
            if (reader != null) reader.close();
            if (clientSocket != null) clientSocket.close();
            System.out.println("Connections closed.");
        } catch (Exception e) {
            System.err.println("Error closing connections: " + e.getMessage());
        }
    }

    private void pressKeyWithShift(int key) {
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.keyPress(key);
        bot.keyRelease(key);
        bot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private void pressKeyWithShiftForSpecialChars(char c) {
        switch (c) {
            case '!':
                pressKeyWithShift(KeyEvent.VK_1);
                break;
            case '@':
                pressKeyWithShift(KeyEvent.VK_2);
                break;
            case '#':
                pressKeyWithShift(KeyEvent.VK_3);
                break;
            case '$':
                pressKeyWithShift(KeyEvent.VK_4);
                break;
            case '%':
                pressKeyWithShift(KeyEvent.VK_5);
                break;
            case '^':
                pressKeyWithShift(KeyEvent.VK_6);
                break;
            case '&':
                pressKeyWithShift(KeyEvent.VK_7);
                break;
            case '*':
                pressKeyWithShift(KeyEvent.VK_8);
                break;
            case '(':
                pressKeyWithShift(KeyEvent.VK_9);
                break;
            case ')':
                pressKeyWithShift(KeyEvent.VK_0);
                break;
            case ':':
                pressKeyWithShift(KeyEvent.VK_SEMICOLON);
                break;
            case '"':
                pressKeyWithShift(KeyEvent.VK_QUOTE);
                break;
            case '<':
                pressKeyWithShift(KeyEvent.VK_COMMA);
                break;
            case '>':
                pressKeyWithShift(KeyEvent.VK_PERIOD);
                break;
            case '?':
                pressKeyWithShift(KeyEvent.VK_SLASH);
                break;
            case '_':
                pressKeyWithShift(KeyEvent.VK_MINUS);
                break;
            case '+':
                pressKeyWithShift(KeyEvent.VK_EQUALS);
                break;
            case '{':
                pressKeyWithShift(KeyEvent.VK_OPEN_BRACKET);
                break;
            case '}':
                pressKeyWithShift(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '|':
                pressKeyWithShift(KeyEvent.VK_BACK_SLASH);
                break;
            case '~':
                pressKeyWithShift(KeyEvent.VK_BACK_QUOTE);
                break;
            default:
                break;
        }
    }

    private boolean isShiftRequired(char c) {
        switch (c) {
            case '!':
            case '@':
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '(':
            case ')':
            case ':':
            case '"':
            case '<':
            case '>':
            case '?':
            case '_':
            case '+':
            case '{':
            case '}':
            case '|':
            case '~':
                return true;
            default:
                return false;
        }
    }

}
