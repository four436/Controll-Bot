import java.io.IOException;
import java.net.ServerSocket;

public class KeyboardServer extends Thread {
    private ServerSocket KeyboardSv;
    private KeyboardCommunication keycomms[] = new KeyboardCommunication[10000];
    public KeyboardServer(int port){
        try {
            KeyboardSv = new ServerSocket(port);
            System.out.println("Server started on port " + port + ". Waiting for a client...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        start();
    }

    @Override
    public void run(){
        for(int i=0 ;i<10000;i++){
            try{
                keycomms[i] = new KeyboardCommunication(KeyboardSv.accept());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
