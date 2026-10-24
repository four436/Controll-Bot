import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MouseCommunication extends Thread {

    private Robot bot;
    private ServerSocket mouseSv;
    private Socket comms;
    private BufferedReader reader;
    private volatile boolean isRunning = true;

    public MouseCommunication(Socket sk) {
        try {
            comms = sk;
            System.out.println("client get");
        } catch (Exception e) {
            System.err.println("Error accepting connection: " + e.getMessage());
        }

        try {
            bot = new Robot();
        } catch (Exception e) {
            System.err.println("Error initializing Robot: " + e.getMessage());
        }

        try {
            reader = new BufferedReader(new InputStreamReader(comms.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error initializing reader: " + e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        while (isRunning) {
            int choice = -1;
            try {
                choice = reader.read();
            } catch (IOException e) {
                System.err.println("Error reading input: " + e.getMessage());
                break;
            }
            switch (choice) {
                case 0:
                    handleMouseMove();
                    break;
                case 1:
                    handleMouseClick();
                    System.out.println("click ");
                    break;
                case 2:
                    handleMouseHold();
                    break;
                case 3:
                    handleMouseReleaseHold();
                    break;
                case 4:
                    handleMouseScroll();
                    break;
                case 5:
                    handleMouseMoveReverse();
                    break;
                default:
                    break;
            }
        }
        closeConnection(); // Ensure resources are closed when the thread stops
    }

    private void handleMouseMove() {
        int x = 0, y = 0;
        try {
            x = reader.read();
            y = reader.read();
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        } catch (IOException e) {
            System.err.println("Error reading mouse move coordinates: " + e.getMessage());
        }
        MouseMove(x, y);
    }

    private void handleMouseClick() {
        int button = 3;
        try {
            button = reader.read();
            System.out.println(button);
        } catch (IOException e) {
            System.err.println("Error reading mouse click button: " + e.getMessage());
        }
        mouseClick(button);
    }

    private void handleMouseHold() {
        int button = 3;
        try {
            button = reader.read();
        } catch (IOException e) {
            System.err.println("Error reading mouse hold button: " + e.getMessage());
        }
        mouseHold(button);
    }

    private void handleMouseReleaseHold() {
        int button = 3;
        try {
            button = reader.read();
        } catch (IOException e) {
            System.err.println("Error reading mouse release button: " + e.getMessage());
        }
        mouseReleaseHold(button);
    }

    private void handleMouseScroll() {
        int direction = 3;
        try {
            direction = reader.read();
        } catch (IOException e) {
            System.err.println("Error reading scroll direction: " + e.getMessage());
        }
        mouseScroll(direction);
    }

    private void handleMouseMoveReverse() {
        int x = 0, y = 0;
        try {
            x = reader.read();
            y = reader.read();
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        } catch (IOException e) {
            System.err.println("Error reading reverse move coordinates: " + e.getMessage());
        }
        MouseMove(-x, -y);
    }

    public void MouseMove(int x, int y) {
        Point mouseCurrentPosition = MouseInfo.getPointerInfo().getLocation();
        int currentX = (int) mouseCurrentPosition.getX();
        int currentY = (int) mouseCurrentPosition.getY();
        try {
            bot.mouseMove(currentX + x, currentY - y);
        } catch (Exception e) {
            System.err.println("Error moving mouse: " + e.getMessage());
        }
    }

    public void mouseClick(int button) {
        try {
            switch (button) {
                case 1 : bot.mousePress(InputEvent.BUTTON1_DOWN_MASK); bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); System.out.println("left"); break;
                case 0 : bot.mousePress(InputEvent.BUTTON3_DOWN_MASK); bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK); System.out.println("right"); break;
                default: break;

            }
        } catch (Exception e) {
            System.err.println("Error clicking mouse: " + e.getMessage());
        }
    }

    public void mouseHold(int button) {
        try {
            switch (button) {
                case 1 : bot.mousePress(InputEvent.BUTTON1_DOWN_MASK); break;
                case 0 : bot.mousePress(InputEvent.BUTTON3_DOWN_MASK); break;
            }
        } catch (Exception e) {
            System.err.println("Error holding mouse: " + e.getMessage());
        }
    }

    public void mouseReleaseHold(int button) {
        try {
            switch (button) {
                case 1 : bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); break;
                case 0 : bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK); break;
            }
        } catch (Exception e) {
            System.err.println("Error releasing mouse: " + e.getMessage());
        }
    }

    public void mouseScroll(int direction) {
        try {
            bot.mouseWheel(direction == 1 ? -1 : 1);
        } catch (Exception e) {
            System.err.println("Error scrolling mouse: " + e.getMessage());
        }
    }

    public void closeConnection() {
        isRunning = false;
        try {
            if (reader != null) {
                reader.close();
            }
            if (comms != null) {
                comms.close();
            }
            if (mouseSv != null) {
                mouseSv.close();
            }
            System.out.println("Connection closed successfully.");
        } catch (IOException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
}
