import java.net.ServerSocket;

public class servertest {

    public static void main(String[] args) {
        try{
            ServerSocket serverS = new ServerSocket(8888);

            while(true){
                Socket clientS = serverS.accept();
                Chandler client_tread = new Chandler(clientS);
                client_tread.start();
            }
        }

        catch(Exception e ){
            System.out.println(e);
        }
        



    }
    
}
