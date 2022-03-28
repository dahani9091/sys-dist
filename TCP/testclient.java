import java.net.Socket;
import java.util.Scanner;

public class testclient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",8888);

            Scanner in = new Scanner(socket.getInputStream());
            PrintWritter out = new PrintWritter(socket.getOutputStream(),true);
    
            out.println("Bonjour a zbi server hada message mn 3nd client");

            String line = in.nextLine();
            if (line != null){
                print("msg from server: "+line);
            }

            in.close();
            out.close();
            socket.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
