import java.net.ServerSocket;

public class servertest {

    public static void main(String[] args) {
        try{
            ServerSocket serverS = new ServerSocket(8888);

            while(true){
                Socket clientS = serverS.accept();
                
            }
        }

        catch(Exception e ){
            System.out.println(e);
        }
        



    }
    
}
