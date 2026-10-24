import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager {

    public static ServerSocket svSk;
    public static Socket sk[] = new Socket[10000];
    private static MouseServer mouseComms;
    private static TextServer textComms;
    private static KeyboardServer keyboardComms;

    public static boolean StartServer(int port){
        try{
            svSk = new ServerSocket(port);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean StartCommunication(){
        mouseComms = new MouseServer(11111);
        textComms = new TextServer(11112);
        keyboardComms = new KeyboardServer(11113);
        return true;
    }

}
