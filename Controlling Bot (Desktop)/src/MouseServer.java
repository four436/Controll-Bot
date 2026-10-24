import java.net.ServerSocket;
import java.net.Socket;

public class MouseServer extends Thread {
    private ServerSocket mouseSv;
    private MouseCommunication mscom[] = new MouseCommunication[10000];

    public MouseServer (int port){
        try {
            mouseSv = new ServerSocket(port);
        } catch (Exception e) {
            System.err.println("Error initializing ServerSocket: " + e.getMessage());
        }
        start();
    }

    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            try{
                mscom [i] = new MouseCommunication(mouseSv.accept());
            } catch (Exception e) {
            }
        }
    }
}
