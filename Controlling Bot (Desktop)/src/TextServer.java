import java.io.IOException;
import java.net.ServerSocket;

public class TextServer extends Thread{
    private ServerSocket serverSocket;
    private TextCommunication txtcomms[] = new TextCommunication[10000];
    public TextServer(int port){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port + ". Waiting for a client...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        start();
    }

    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            try {
                txtcomms[i] = new TextCommunication(serverSocket.accept());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
