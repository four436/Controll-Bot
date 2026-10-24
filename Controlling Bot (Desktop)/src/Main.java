import javax.swing.plaf.basic.BasicMenuUI;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sarting server and waiting for client");
        if(ServerManager.StartServer(11110)){
            System.out.println("Started");
            try {
                ServerManager.sk[0] = ServerManager.svSk.accept();
            } catch (Exception e) {
                System.out.println("failed to accept");
            }
            if (ServerManager.StartCommunication()) {
                System.out.println("COMMS started");
            } else {
                System.out.println("COMMS failed");
            }
            for(int i = 1; i < ServerManager.sk.length; i++) {
                try {
                    ServerManager.sk[i] = ServerManager.svSk.accept();
                } catch (Exception e) {
                    System.out.println("failed to accept");
                }
            }
        }
    }
}